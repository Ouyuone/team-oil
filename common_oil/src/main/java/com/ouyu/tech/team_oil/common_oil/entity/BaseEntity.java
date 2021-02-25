package com.ouyu.tech.team_oil.common_oil.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-01-31 14:40
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
public class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy;


    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


    /**
     * select = false 是查询时不显示字段
     * TableLogic value是未删除的值 delval是已删除的值
     * @author ouyu
     */
    @TableField(select = false)
    @TableLogic(value = "0",delval = "1")
    private Boolean isDel;
}
