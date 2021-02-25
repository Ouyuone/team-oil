package com.ouyu.tech.team_oil.common_oil.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 14:38
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
@Accessors(chain = true)
public class TransferOrderVo {
    private Integer userId;

    private BigDecimal transferBalance;

    private String typeCode;

    private String typeName;

    private String acceptAccount;

    private String acceptAccountName;

    private BigDecimal balance;

}
