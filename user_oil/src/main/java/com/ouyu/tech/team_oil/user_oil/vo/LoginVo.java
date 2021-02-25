package com.ouyu.tech.team_oil.user_oil.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-10 09:59
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("用户登录信息")
public class LoginVo {
    @ApiModelProperty(value = "登录名")
    private String username;
    @ApiModelProperty("登录密码")
    private String password;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("验证码")
    private String captcha;
}
