package com.ouyu.tech.message_oil.controller;

import com.ouyu.tech.message_oil.service.SendMessageService;
import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.util.RedisManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-10 11:04
 * @Description: 验证码控制层
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@RestController
@RequestMapping("/captcha")
@AllArgsConstructor
@Api(value = "验证码服务",tags = "提供验证码服务")
public class CaptchaController {

    final RedisManager redisManager;
    final SendMessageService sendMessageService;

    @GetMapping("/validCaptcha")
    @ApiOperation("验证验证码")
    public ResponseData validCaptcha(@RequestParam String storageKey,@RequestParam String captcha) {
        String key = redisManager.getKey(storageKey);
        if(key != null && key.equals(captcha)){
            return ResponseData.ok(true,"验证码正确");
        }
        return ResponseData.ok(false,"验证码错误");
    }

    @GetMapping("/getCaptcha")
    @ApiOperation("获取验证码")
    @ApiImplicitParam(name = DescribeConstant.Header.X_CURRENT_TOKEN,value = "Token",required = false,dataType = "string",paramType = "header")
    public ResponseData getCaptcha(@RequestParam String storageKey){
        return ResponseData.ok(sendMessageService.sendPhoneCaptcha(storageKey));
    }

}