package com.ouyu.tech.team_oil.user_oil;

import com.ouyu.tech.team_oil.common_oil.annotation.EnableInterceptorToken;
import com.ouyu.tech.team_oil.user_oil.config.FeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableInterceptorToken
@MapperScan(basePackages = "com.ouyu.tech.team_oil.user_oil.mapper")
@ComponentScan("com.ouyu.tech.team_oil")
@EnableFeignClients(basePackages = "com.ouyu.tech.team_oil.user_oil.fetch",defaultConfiguration = FeignConfiguration.class)
public class UserOilApplication {



    public static void main(String[] args) {
        //SpringApplication.run(UserOilApplication.class, args);
        SpringApplication application = new SpringApplication(UserOilApplication.class);
        application.setBanner((environment,sourceClass,out)->{
           out.println("┬ ┬┌─┐┌─┐┬─┐   ┌─┐┬┬\n" +
                       "│ │└─┐├┤ ├┬┘───│ │││  \n" +
                       "└─┘└─┘└─┘┴└─   └─┘┴┴─┘\n" +
                       "V1.0==>2021-02-08");
        });
        application.run(args);
    }
}
