package com.ouyu.tech.team_oil.user_oil.service;

import com.ouyu.tech.team_oil.user_oil.entity.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ouyu.tech.team_oil.user_oil.vo.TransferVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ouyu
 * @since 2021-02-19
 */
public interface IWalletService extends IService<Wallet> {

    Object balance();

    Object transfer(TransferVo transferVo);

    Object findUser(TransferVo transferVo);
}
