package com.dsy.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerAuthApplication.class, args);
	}

}
