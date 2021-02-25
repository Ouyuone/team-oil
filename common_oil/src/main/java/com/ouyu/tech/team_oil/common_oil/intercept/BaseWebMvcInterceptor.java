package com.ouyu.tech.team_oil.common_oil.intercept;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ouyu.tech.team_oil.common_oil.constant.DescribeConstant;
import com.ouyu.tech.team_oil.common_oil.util.CommonJwtUtil;
import com.ouyu.tech.team_oil.common_oil.util.TokenThreadUtil;
import com.ouyu.tech.team_oil.common_oil.util.UserThreadUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-20 16:52
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Slf4j
@Component
public class BaseWebMvcInterceptor implements HandlerInterceptor {

    @Autowired
    CommonJwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(DescribeConstant.Header.X_CURRENT_TOKEN);
        if(StringUtils.isBlank(token)){
            log.error("请携带{}请求头，再访问",DescribeConstant.Header.X_CURRENT_TOKEN);
            throw new IllegalArgumentException(String.format("请携带%s请求头，再访问",DescribeConstant.Header.X_CURRENT_TOKEN));
        }
        //解析token拿到对应的用户id
        Jws<Claims> claimsJws = jwtUtil.resolverToken(token);
        String issuer = claimsJws.getBody().getIssuer();
        TokenThreadUtil.setToken(token);
        UserThreadUtil.setUserId(Integer.valueOf(issuer));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TokenThreadUtil.remove();
        UserThreadUtil.remove();
    }
}
