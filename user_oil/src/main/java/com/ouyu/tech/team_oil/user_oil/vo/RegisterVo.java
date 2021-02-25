package com.ouyu.tech.team_oil.user_oil.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-09 15:25
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
@ApiModel("用户注册信息")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterVo {

    @ApiModelProperty(value = "用户名",dataType = "String")
    private String username;
    @ApiModelProperty(value = "密码",dataType = "String")
    private String password;
    @ApiModelProperty(value = "重复密码",dataType = "String")
    private String rePassword;
    @ApiModelProperty(value = "手机",dataType = "String")
    private String phone;
    @ApiModelProperty(value = "同意注册协议",dataType = "Boolean")
    private Boolean agreeProtocol;

}
