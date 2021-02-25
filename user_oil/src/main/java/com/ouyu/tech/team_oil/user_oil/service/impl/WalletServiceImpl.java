package com.ouyu.tech.team_oil.user_oil.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.exception.MessageException;
import com.ouyu.tech.team_oil.common_oil.util.UserThreadUtil;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.entity.Wallet;
import com.ouyu.tech.team_oil.user_oil.fetch.order.TransferOrderFeign;
import com.ouyu.tech.team_oil.user_oil.mapper.WalletMapper;
import com.ouyu.tech.team_oil.user_oil.service.IUserService;
import com.ouyu.tech.team_oil.user_oil.service.IWalletService;
import com.ouyu.tech.team_oil.user_oil.vo.TransferVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 * 加上onConstructor = @__(@Lazy) 是为了解决构造函数依赖的造成的循环依赖问题
 * 通过在构造函数上增加@Lazy注解使依赖后续再注入
 * @author ouyu
 * @since 2021-02-19
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements IWalletService {

    //@Autowired
    //@Lazy
    private IUserService userService;

    final TransferOrderFeign transferOrderFeign;


    @Override
    public Object balance() {
        Integer userId = UserThreadUtil.getUserId();
        List<Wallet> wallets = list(Wrappers.lambdaQuery(Wallet.class)
                .eq(Wallet::getUserId, userId));
        if(CollectionUtils.isEmpty(wallets)){
            log.error("未有钱包，请确认是否登录");
            throw new MessageException("未有钱包，请确认是否登录");
        }
        wallets = wallets.stream().peek((wallet -> {
            BigDecimal balance = wallet.getBalance();
            BigDecimal freezeBalance = wallet.getFreezeBalance();
            //设置可转让金额
            wallet.setAvailableBalance(balance.subtract(freezeBalance));
        })).collect(Collectors.toList());
        return wallets;
    }

    @Override
    @Transactional
    public Object transfer(TransferVo transferVo) {
        String accountCode = transferVo.getAccountCode();
        if(StringUtils.isBlank(accountCode)){
            log.error("请先填写账号或手机号");
            throw new MessageException("请先填写账号号或手机号");
        }
        Integer userId = UserThreadUtil.getUserId();
        Wallet transferWallet= getOne(Wrappers.lambdaQuery(Wallet.class)
        .eq(Wallet::getUserId,userId)
        .eq(Wallet::getTypeCode,transferVo.getTypeCode()));
        if(transferWallet == null){
            log.error("卡包不存在");
            throw new MessageException("卡包不存在");
        }
        //用户需要转让的额度
        BigDecimal money = transferVo.getMoney();
        //计算出用户可转让的额度;
        BigDecimal availableMoney = transferWallet.getBalance().subtract(transferWallet.getFreezeBalance());
        if(availableMoney.subtract(money).intValue() < 0){
            log.error("可转让额度不够");
            throw new MessageException("可转让额度不够");
        }
        //接收方账户
        User acceptUser =findUserByPhoeOrAccountCode(accountCode);
        //接收方不能是转账方也就是不能自己转给自己
        if(acceptUser.getId().intValue() == userId){
            log.error("不能转账给自己");
            throw new IllegalArgumentException("不能转账给自己");
        }
        Wallet acceptWallet = getOne(Wrappers.lambdaQuery(Wallet.class)
        .eq(Wallet::getUserId,acceptUser.getId())
        .eq(Wallet::getTypeCode,transferVo.getTypeCode()));
        //接收方增加金额
        acceptWallet.setBalance(acceptWallet.getBalance().add(transferVo.getMoney()));
        boolean acceptStatus = updateById(acceptWallet);
        //转让方扣除掉转让的额度
        transferWallet.setBalance(transferWallet.getBalance().subtract(money));
        boolean transferStatus = updateById(transferWallet);
        //组装转账订单信息
        TransferOrderVo transferOrderVo = new TransferOrderVo()
                .setUserId(userId)
                .setAcceptAccount(accountCode)
                .setAcceptAccountName(acceptUser.getUsername())
                .setBalance(money)
                .setTypeCode(transferWallet.getTypeCode())
                .setTypeName(transferWallet.getTypeName())
                .setTransferBalance(transferWallet.getBalance());
        //记录转账新
        ResponseData transferInfo = transferOrderFeign.addTransferOrder(transferOrderVo);
        if(transferInfo.getCode() !=0){
            log.error("调用转账服务保存转账信息错误");
            throw new IllegalArgumentException("调用转账服务保存转账信息错误");
        }
        return acceptStatus && transferStatus;
    }

    /**
     * 根据手机号或账号查找用户
     * @author ouyu
     */
    private User findUserByPhoeOrAccountCode(String accountCode) {
        User user = userService.getOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getAccountCode,accountCode)
                .or()
                .eq(User::getPhone,accountCode));
        if(user == null){
            log.error("没有此账号");
            throw new MessageException("没有此账号");
        }
        return user;
    }

    @Override
    public Object findUser(TransferVo transferVo) {
        String accountCode = transferVo.getAccountCode();
        if(StringUtils.isBlank(accountCode)){
            log.error("请先填写账号或手机号");
            throw new MessageException("请先填写账号号或手机号");
        }
       return findUserByPhoeOrAccountCode(accountCode);
    }
}
