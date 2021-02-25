package com.ouyu.tech.message_oil;

import com.ouyu.tech.team_oil.common_oil.annotation.EnableInterceptorToken;
import com.ouyu.tech.team_oil.common_oil.annotation.EnableRedis;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
@EnableRedis
@EnableInterceptorToken
@ComponentScan(basePackages = {"com.ouyu.tech.team_oil.common_oil","com.ouyu.tech.message_oil"})
public class MessageOilApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MessageOilApplication.class, args);
        SpringApplication application = new SpringApplication(MessageOilApplication.class);
        application.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("┌┬┐┌─┐┌─┐┌─┐┌─┐┌─┐┌─┐  ┌─┐┬┬  \n" +
                            "│││├┤ └─┐└─┐├─┤│ ┬├┤───│ │││  \n" +
                            "┴ ┴└─┘└─┘└─┘┴ ┴└─┘└─┘  └─┘┴┴─┘\n" +
                            "V1.0==>2021.02.10");
            }
        });
        application.run(args);

    }

}
