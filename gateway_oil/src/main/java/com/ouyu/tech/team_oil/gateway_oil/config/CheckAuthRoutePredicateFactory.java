package com.ouyu.tech.team_oil.gateway_oil.config;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;
/**
 * 自定义predicate断言
 * @author ouyu
 */
@Component
public class CheckAuthRoutePredicateFactory
        extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            String name = exchange.getRequest().getQueryParams().getFirst("name");
            System.err.println("进入了CheckAuthRoutePredicateFactory\t" + name);
            if (config.getName().equals(name)) {
                return true;
            }
            return false;
        };
    }
    public static class Config {
        private String name;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}