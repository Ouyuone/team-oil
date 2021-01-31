package com.ouyu.tech.team_oil.order_oil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ouyu.tech.team_oil.order_oil.mapper")
public class OrderOilApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderOilApplication.class, args);
    }

}
