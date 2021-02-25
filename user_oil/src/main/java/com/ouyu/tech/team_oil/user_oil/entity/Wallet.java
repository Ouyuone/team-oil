package com.ouyu.tech.team_oil.user_oil.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.ouyu.tech.team_oil.common_oil.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("wallet")
@ApiModel(value="Wallet对象", description="钱包")
public class Wallet extends BaseEntity {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "关联用户")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "类型")
    @TableField("type_code")
    private String typeCode;

    @ApiModelProperty(value = "类型名(气卡、油卡)")
    @TableField("type_name")
    private String typeName;

    @ApiModelProperty(value = "余额",example = "0")
    @TableField("balance")
    private BigDecimal balance;

    @ApiModelProperty(value = "冻结金额",example = "0")
    @TableField("freeze_balance")
    private BigDecimal freezeBalance;

    @TableField(exist = false)
    private BigDecimal availableBalance;
}
