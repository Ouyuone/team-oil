package com.ouyu.tech.team_oil.common_oil.annotation;

import com.ouyu.tech.team_oil.common_oil.config.RedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 11:01
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisConfig.class)
public @interface EnableRedis {
}
