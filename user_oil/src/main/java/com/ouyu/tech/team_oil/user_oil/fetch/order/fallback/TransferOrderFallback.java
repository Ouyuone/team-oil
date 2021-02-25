package com.ouyu.tech.team_oil.user_oil.fetch.order.fallback;

import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.user_oil.fetch.order.TransferOrderFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 14:53
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Component
public class TransferOrderFallback implements TransferOrderFeign {
    @Override
    public ResponseData addTransferOrder(@RequestBody TransferOrderVo transferOrderVo) {
        return ResponseData.fail("网络问题，请求失败",999);
    }
}
