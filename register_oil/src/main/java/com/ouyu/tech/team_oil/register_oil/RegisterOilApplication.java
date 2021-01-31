package com.ouyu.tech.team_oil.register_oil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterOilApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterOilApplication.class, args);
    }

}
