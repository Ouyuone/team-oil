package com.ouyu.tech.team_oil.user_oil.controller;


import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.user_oil.service.IUserService;
import com.ouyu.tech.team_oil.user_oil.vo.LoginVo;
import com.ouyu.tech.team_oil.user_oil.vo.RegisterVo;
import com.ouyu.tech.team_oil.user_oil.vo.UserInfoVo;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.Objects;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
@Api("用户信息APi")
@Slf4j
@RestController
@RequestMapping("/user_oil")
@AllArgsConstructor
public class UserController {

    final IUserService userService;

    @ApiOperation("用户登录")
    @ApiImplicitParam(name= DescribeConstant.Header.X_CURRENT_TOKEN,value = "Token",required = false,paramType = "header",dataType = "string")
    @PostMapping("/doLogin")
    public ResponseData doLogin(HttpServletRequest request, @RequestBody LoginVo loginVo){
        String header_oil = request.getHeader("X-Request-oil");
        if(StringUtils.isNotBlank(header_oil) && Objects.equals("Bar",header_oil)){
            log.info("特殊身份登录");
        }
        // TODO开发登录功能
        return ResponseData.ok(userService.doLogin(loginVo),"登录成功");
    }

    @ApiOperation("注册服务")
    @ApiImplicitParam(name= DescribeConstant.Header.X_CURRENT_TOKEN,value = "Token",required = false,paramType = "header",dataType = "string")
    @ApiResponses(@ApiResponse(response = ResponseData.class,code = 0,message = "成功"))
    @PostMapping("/doRegister")
    public ResponseData doRegister(@RequestBody RegisterVo registerVo){
            return ResponseData.ok(userService.doRegister(registerVo),"注册成功");
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/editUserInfo")
    public ResponseData editUserInfo(@RequestBody UserInfoVo userInfoVo){
        return ResponseData.ok(userService.editUserInfo(userInfoVo));
    }

    @ApiOperation("绑定手机号")
    @PostMapping("/bindPhone")
    public ResponseData bindPhone(@RequestBody UserInfoVo userInfoVo){
        return ResponseData.ok(userService.bindPhone(userInfoVo));
    }

}
