package com.ouyu.tech.team_oil.user_oil.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 17:43
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :s
 * </pre>
 */
@Data
@ApiModel("转让传输类")
public class TransferVo {

    @ApiModelProperty(value = "员工号或手机号",dataType = "String",required = true)
    private String accountCode;

    @ApiModelProperty(value = "转让金额",example = "0")
    private BigDecimal money;

    @ApiModelProperty(value = "卡包类型")
    private String typeCode;
}
