package com.ouyu.tech.team_oil.user_oil.fetch.message;

import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.user_oil.config.FeignConfiguration;
import com.ouyu.tech.team_oil.user_oil.fetch.message.fallback.CaptchaFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-10 10:51
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@FeignClient(value = DescribeConstant.Server.TEAM_OIL_MESSAGE
        , configuration = FeignConfiguration.class
        , fallback = CaptchaFallback.class)
public interface CaptchaFeign {
    @GetMapping("/captcha/validCaptcha")
    public ResponseData<Boolean> validCaptcha(@RequestParam String storageKey,@RequestParam String captcha);
}
