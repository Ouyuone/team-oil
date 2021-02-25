package com.ouyu.tech.team_oil.gateway_oil.config;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-01 15:14
 * @Description: 全局过滤
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Configuration
public class GlobalFilter {

    @Bean
    @Order(1)
    public org.springframework.cloud.gateway.filter.GlobalFilter c(){
       return (exchange,chain)->{
           System.out.println("first pre filter");
          return chain.filter(exchange).then(Mono.fromRunnable(()->{
              System.out.println("first post filter");
           }));
        };
    }

    @Bean
    public KeyResolver ipKeyResolver(){
        return exchange -> {
            return Mono.just(getIpAddr(exchange.getRequest()));
        };
    }
    private static String getIpAddr(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        List<String> ips = headers.get("X-Forwarded-For");
        String ip = "192.168.1.1";
        if (ips != null && ips.size() > 0) {
            ip = ips.get(0);
        }
        return ip;
    }
}
