package com.ouyu.tech.team_oil.order_oil;

import com.ouyu.tech.team_oil.common_oil.annotation.EnableInterceptorToken;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
@EnableEurekaClient
@EnableInterceptorToken
@MapperScan(basePackages = "com.ouyu.tech.team_oil.order_oil.mapper")
@ComponentScan("com.ouyu.tech.team_oil")
public class OrderOilApplication {

    public static void main(String[] args) {
        //SpringApplication.run(OrderOilApplication.class, args);
        SpringApplication application = new SpringApplication(OrderOilApplication.class);
        application.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("┌─┐┬─┐┌┬┐┌─┐┬─┐   ┌─┐┬┬  \n" +
                            "│ │├┬┘ ││├┤ ├┬┘───│ │││  \n" +
                            "└─┘┴└──┴┘└─┘┴└─   └─┘┴┴─┘\n" +
                            "V1.0==>2021.02.08");
            }
        });
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }

}
