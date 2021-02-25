package com.ouyu.tech.team_oil.order_oil.controller;


import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.order_oil.service.ITransferOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 转账订单
 * </p>
 *
 * @author ouyu
 * @since 2021-02-20
 */
@Api(value = "转账订单", tags = "记录转账记录")
@RestController
@RequestMapping("/transferOrder")
@AllArgsConstructor
public class TransferOrderController {

    private ITransferOrderService transferOrderService;

    @ApiOperation(value = "添加转账记录")
    @PostMapping("/addTransferOrder")
    public ResponseData addTransferOrder(@RequestBody TransferOrderVo transferOrderVo) {
        return ResponseData.ok(transferOrderService.addTransferOrder(transferOrderVo));
    }
}
