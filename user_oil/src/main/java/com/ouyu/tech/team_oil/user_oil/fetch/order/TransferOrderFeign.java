package com.ouyu.tech.team_oil.user_oil.fetch.order;

import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.user_oil.config.FeignConfiguration;
import com.ouyu.tech.team_oil.user_oil.fetch.order.fallback.TransferOrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 14:51
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@FeignClient(value = DescribeConstant.Server.TEAM_OIL_ORDER
        ,configuration = FeignConfiguration.class)
public interface TransferOrderFeign {

    @PostMapping(value = "/transferOrder/addTransferOrder")
    public ResponseData addTransferOrder(@RequestBody TransferOrderVo transferOrderVo);
}