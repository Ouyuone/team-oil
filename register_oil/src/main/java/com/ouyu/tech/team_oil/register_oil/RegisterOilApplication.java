package com.ouyu.tech.team_oil.register_oil;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
@EnableEurekaServer
public class RegisterOilApplication {

    public static void main(String[] args) {
        //SpringApplication.run(RegisterOilApplication.class, args);
        SpringApplication application = new SpringApplication(RegisterOilApplication.class);
        application.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("┬─┐┌─┐┌─┐┬┌─┐┌┬┐┌─┐┬─┐   ┌─┐┬┬  \n" +
                            "├┬┘├┤ │ ┬│└─┐ │ ├┤ ├┬┘───│ │││  \n" +
                            "┴└─└─┘└─┘┴└─┘ ┴ └─┘┴└─   └─┘┴┴─┘\n" +
                            "V1.0==>2021.02.08");
            }
        });
        application.run(args);
    }

}
