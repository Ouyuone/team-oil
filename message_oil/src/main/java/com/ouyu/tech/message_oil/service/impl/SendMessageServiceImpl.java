package com.ouyu.tech.message_oil.service.impl;

import com.ouyu.tech.message_oil.service.SendMessageService;
import com.ouyu.tech.message_oil.util.SendMessageUtil;
import com.ouyu.tech.team_oil.common_oil.util.RedisManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 11:26
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Service
@Slf4j
@AllArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {
    final RedisManager redisManager;

    @Override
    public String sendPhoneCaptcha(String storageKey) {
        String captcha = SendMessageUtil.sendPhoneCaptcha();
        redisManager.setKey(storageKey,captcha);
        return captcha;
    }
}
