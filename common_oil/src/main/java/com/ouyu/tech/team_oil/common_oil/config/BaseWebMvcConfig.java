package com.ouyu.tech.team_oil.common_oil.config;

import com.ouyu.tech.team_oil.common_oil.intercept.BaseWebMvcInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 16:50
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Order(500)
public class BaseWebMvcConfig implements WebMvcConfigurer {
    private String[] swaggerPath = {"/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/csrf"};
    @Autowired
    BaseWebMvcInterceptor baseWebMvcInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseWebMvcInterceptor)
                .addPathPatterns("/**")
        .excludePathPatterns(swaggerPath)
        .excludePathPatterns("/");
    }
}
