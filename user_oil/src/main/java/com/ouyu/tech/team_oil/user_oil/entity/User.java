package com.ouyu.tech.team_oil.user_oil.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import com.ouyu.tech.team_oil.common_oil.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
@ApiModel(value="User对象", description="用户表")
public class User extends BaseEntity {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "昵称")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty("性别")
    @TableField(value = "sex")
    private String sex;

    @ApiModelProperty(value = "加盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "头像")
    @TableField("head_picture")
    private Integer headPicture;

    @ApiModelProperty(value = "手机")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "员工号")
    @TableField("account_code")
    private String accountCode;

    @ApiModelProperty(value = "总积分",example = "0")
    @TableField("integral")
    private BigDecimal integral;

    @ApiModelProperty(value = "openId")
    @TableField("openId")
    private String openid;

    @ApiModelProperty(value = "角色Code")
    @TableField("role_code")
    private String roleCode;


}
