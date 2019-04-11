package com.dsy.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLogConfiguration {

	@Bean
	Logger.Level feignLoggerLever() {
		return Logger.Level.FULL;
	}

}
