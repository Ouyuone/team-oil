package com.ouyu.tech.team_oil.user_oil.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.entity.OilClaims;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.exception.CaptchaValidErrorException;
import com.ouyu.tech.team_oil.common_oil.exception.MessageException;
import com.ouyu.tech.team_oil.common_oil.util.CommonJwtUtil;
import com.ouyu.tech.team_oil.common_oil.util.EncryptUtil;
import com.ouyu.tech.team_oil.common_oil.util.SaltUtil;
import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.entity.Wallet;
import com.ouyu.tech.team_oil.user_oil.fetch.message.CaptchaFeign;
import com.ouyu.tech.team_oil.user_oil.mapper.UserMapper;
import com.ouyu.tech.team_oil.user_oil.service.IUserService;
import com.ouyu.tech.team_oil.user_oil.service.IWalletService;
import com.ouyu.tech.team_oil.user_oil.vo.LoginVo;
import com.ouyu.tech.team_oil.user_oil.vo.RegisterVo;
import com.ouyu.tech.team_oil.user_oil.vo.UserInfoVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    final CommonJwtUtil userJwtUtil;
    final CaptchaFeign captchaFeign;
    final IWalletService walletService;

    @Override
    @Transactional
    public Object doRegister(RegisterVo registerVo) {
        if (Objects.isNull(registerVo.getPassword()) || Objects.isNull(registerVo.getRePassword())) {
            log.error("密码不能为空");
            throw new MessageException("密码不能为空");
        }
        if (registerVo.getPassword().compareTo(registerVo.getRePassword()) != 0) {
            log.error("两次输入密码不同");
            throw new MessageException("两次输入密码不同");
        }
        if (!registerVo.getAgreeProtocol()) {
            log.error("请先同意协议文件");
            throw new MessageException("请先同意协议文件");
        }
        String password = registerVo.getPassword();
        String username = registerVo.getUsername();
        String phone = registerVo.getPhone();
        //获取salt
        String salt = SaltUtil.getSalt();
        String md5 = EncryptUtil.encryptMd5(password, salt);
        User user = new User()
                .setUsername(username)
                .setPassword(md5)
                .setPhone(phone)
                .setSalt(salt);
        boolean saveStatus = save(user);
        if (!saveStatus) {
            log.error("用户{}保存失败", username);
            throw new MessageException(String.format("用户%s保存失败,请重新再试！", username));
        }
        //初始化钱包卡包
        initWallet(user);
        OilClaims oilClaims = new OilClaims();
        oilClaims.setIssuer(user.getId().toString());
        return userJwtUtil.generateToken(oilClaims);
    }

    /**
     * 初始化钱包卡包
     *
     * @param user
     * @return void
     * @author ouyu
     * @date 2021-02-19
     */
    private void initWallet(User user) {
        List<Wallet> walletList = new ArrayList<>();
        Wallet walletGas = new Wallet();
        walletGas.setUserId(user.getId())
                .setBalance(new BigDecimal(0))
                .setFreezeBalance(new BigDecimal(0))
                .setTypeCode(DescribeConstant.Wallet.CardType.GAS)
                .setTypeName(DescribeConstant.Wallet.CardType.GAS_NAME);
        walletList.add(walletGas);
        Wallet walletIol = new Wallet();
        walletIol.setUserId(user.getId())
                .setBalance(new BigDecimal(0))
                .setFreezeBalance(new BigDecimal(0))
                .setTypeCode(DescribeConstant.Wallet.CardType.OIL)
                .setTypeName(DescribeConstant.Wallet.CardType.OIL_NAME);
        walletList.add(walletIol);
        //初始化保存钱包卡包
        walletService.saveBatch(walletList);
    }

    @Override
    public Object doLogin(LoginVo loginVo) {
        String captcha = loginVo.getCaptcha();
        ResponseData<Boolean> responseData = captchaFeign
                .validCaptcha(StringUtils.isNotBlank(loginVo.getUsername()) ? loginVo.getUsername() : loginVo.getPhone(), captcha);
        if (responseData.getCode() == 0 && responseData.getData()) {
            log.info("验证码验证成功");
        } else {
            log.error("验证码错误");
            throw new CaptchaValidErrorException();
        }
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        String phone = loginVo.getPhone();
        String token = null;
        //使用用户名登录
        if (StringUtils.isNotBlank(username)) {
            token = validLogin(User::getUsername, username, password);
            //使用手机号登录
        } else if (StringUtils.isNotBlank(phone)) {
            token = validLogin(User::getPhone, phone, password);
        }
        return token;
    }

    /**
     * 登录验证
     *
     * @param sFunction
     * @param loginFeild
     * @param password
     * @return java.lang.String
     * @author ouyu
     * @date 2021-02-18
     */
    private String validLogin(SFunction<User, String> sFunction, String loginFeild, String password) {
        User user = getOne(Wrappers.lambdaQuery(User.class)
                .eq(sFunction, loginFeild));
        if (user == null) {
            log.error("用户名或手机号错误");
            throw new MessageException("用户名或手机号错误");
        }
        String salt = user.getSalt();
        String encryptMd5 = EncryptUtil.encryptMd5(password, salt);
        if (!encryptMd5.equals(user.getPassword())) {
            log.error("密码错误！");
            throw new MessageException("密码错误！");
        }
        OilClaims claims = (OilClaims) new OilClaims().setIssuer(user.getId().toString());
        return userJwtUtil.generateToken(claims);
    }

    @Override
    @Transactional
    public Object editUserInfo(UserInfoVo userInfoVo) {
        if (userInfoVo.getId() == null || userInfoVo.getId() == 0) {
            log.error("请先登录，谢谢");
            throw new MessageException("请先登录，谢谢");
        }
        User user = userInfoVo.convert();
        //防止前端把手机号带过来进行了修改
        user.setPhone(null);
        return updateById(user);
    }

    /**
     * 绑定手机号
     *
     * @param userInfoVo
     * @return java.lang.Object
     * @author ouyu
     * @date 2021-02-19
     */
    @Override
    public Object bindPhone(UserInfoVo userInfoVo) {
        if (userInfoVo.getId() == null || userInfoVo.getId() == 0) {
            log.error("请先登录，谢谢");
            throw new MessageException("请先登录，谢谢");
        }
        String phone = userInfoVo.getPhone();
        String captcha = userInfoVo.getCaptcha();
        ResponseData<Boolean> data = captchaFeign.validCaptcha(phone, captcha);
        if (data.getCode() == 0 && data.getData()) {
            return updateById(new User().setPhone(phone));
        }
        return false;
    }
}
