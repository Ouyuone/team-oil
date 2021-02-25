package com.ouyu.tech.team_oil.gateway_oil;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
@EnableEurekaClient
public class GatewayOilApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GatewayOilApplication.class, args);
		SpringApplication application = new SpringApplication(GatewayOilApplication.class);
		application.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.println("┌─┐┌─┐┌┬┐┌─┐┬ ┬┌─┐┬ ┬   ┌─┐┬┬  \n" +
							"│ ┬├─┤ │ ├┤ │││├─┤└┬┘───│ │││  \n" +
							"└─┘┴ ┴ ┴ └─┘└┴┘┴ ┴ ┴    └─┘┴┴─┘\n" +
							"V1.0==>2021.02.08");
			}
		});
		application.run(args);
	}

}
