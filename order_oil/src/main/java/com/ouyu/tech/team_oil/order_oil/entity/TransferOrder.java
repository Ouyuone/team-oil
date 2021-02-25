package com.ouyu.tech.team_oil.order_oil.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.ouyu.tech.team_oil.common_oil.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.order_oil.convert.BaseConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ouyu
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("transfer_order")
@ApiModel(value="TransferOrder对象", description="")
public class TransferOrder extends BaseEntity {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "转账金额")
    @TableField("transfer_balance")
    private BigDecimal transferBalance;

    @ApiModelProperty(value = "类型")
    @TableField("type_code")
    private String typeCode;

    @ApiModelProperty(value = "类型名(气卡，油卡)")
    @TableField("type_name")
    private String typeName;

    @ApiModelProperty(value = "接收转账的账户")
    @TableField("accept_account")
    private String acceptAccount;

    @ApiModelProperty(value = "接收转账的用户名")
    @TableField("accept_account_name")
    private String acceptAccountName;

    @ApiModelProperty(value = "转账后的余额")
    @TableField("balance")
    private BigDecimal balance;


    public static TransferOrder convertTo(TransferOrderVo transferOrderVo){
        return BaseConvert.BASE_CONVERT.convertTo(transferOrderVo);
    }
}
