package com.ouyu.tech.team_oil.order_oil.service.impl;

import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.order_oil.entity.TransferOrder;
import com.ouyu.tech.team_oil.order_oil.mapper.TransferOrderMapper;
import com.ouyu.tech.team_oil.order_oil.service.ITransferOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ouyu
 * @since 2021-02-20
 */
@Service
@Slf4j
public class TransferOrderServiceImpl extends ServiceImpl<TransferOrderMapper, TransferOrder> implements ITransferOrderService {

    @Override
    public Object addTransferOrder(TransferOrderVo transferOrderVo) {
        TransferOrder transferOrder = TransferOrder.convertTo(transferOrderVo);
        return save(transferOrder);
    }
}
