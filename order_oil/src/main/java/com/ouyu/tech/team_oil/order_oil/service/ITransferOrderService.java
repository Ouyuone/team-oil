package com.ouyu.tech.team_oil.order_oil.service;

import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.order_oil.entity.TransferOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ouyu
 * @since 2021-02-20
 */
public interface ITransferOrderService extends IService<TransferOrder> {

    Object addTransferOrder(TransferOrderVo transferOrderVo);
}
