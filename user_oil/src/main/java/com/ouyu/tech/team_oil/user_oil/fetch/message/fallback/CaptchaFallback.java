package com.ouyu.tech.team_oil.user_oil.fetch.message.fallback;

import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.user_oil.fetch.message.CaptchaFeign;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-18 14:20
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Component
public class CaptchaFallback implements CaptchaFeign {

    @Override
    public ResponseData validCaptcha(String storageKey,String captcha) {
        return ResponseData.fail("获取失败，请刷新一下",999);
    }
}
