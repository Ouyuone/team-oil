package com.ouyu.tech.team_oil.user_oil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ouyu.tech.team_oil.user_oil.mapper")
@ComponentScan("com.ouyu.tech.team_oil")
public class UserOilApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserOilApplication.class, args);
    }

}
