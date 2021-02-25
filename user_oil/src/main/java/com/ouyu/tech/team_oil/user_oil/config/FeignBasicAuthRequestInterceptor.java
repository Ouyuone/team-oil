package com.ouyu.tech.team_oil.user_oil.config;

import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.util.TokenThreadUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-18 08:56
 * @Description: 自定义feign请求拦截
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //TODO 业务代码 添加token请求头
        //requestTemplate.header(DescribeConstant.Header.X_CURRENT_TOKEN, "12");
        //System.out.println("我是你打"+requestTemplate.header(DescribeConstant.Header.X_CURRENT_TOKEN));
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        System.out.println("我是请求"+attributes.toString());
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                //requestTemplate.header(DescribeConstant.Header.X_CURRENT_TOKEN, TokenThreadUtil.getToken());
                requestTemplate.header(name, values);
            }
        }
    }
}
