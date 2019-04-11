package com.dsy.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dsy.consumer.config.FeignConfiguration;
import com.dsy.consumer.entity.User;

import feign.Param;
import feign.RequestLine;

// @FeignClient(name="microservice-provider-user", url="http://localhost:8000/")
// @FeignClient(name="microservice-provider-user")
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

//	@GetMapping("/{id}")
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);

}
