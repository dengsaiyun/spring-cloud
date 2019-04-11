package com.dsy.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfiguration {

	/**
	 * 将契约改为feign原生的默认契约.这样就可以使用feign自带的注解了
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

}
