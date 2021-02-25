package com.ouyu.tech.team_oil.user_oil.config;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import java.util.concurrent.TimeUnit;


/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-10 11:13
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Configuration
public class FeignConfiguration {
    /**
     * feign日志级别
     * @author ouyu
     */
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options(){
        //通过options配置连接超时时间和读取超时时间 默认连接超时时间为10s 读取超时时间为60s
        return new Request.Options(10*1000,TimeUnit.MILLISECONDS,60*1000, TimeUnit.MILLISECONDS,true);
    }

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        //return new BasicAuthRequestInterceptor("user", "password");
        return  new FeignBasicAuthRequestInterceptor();
    }
}
