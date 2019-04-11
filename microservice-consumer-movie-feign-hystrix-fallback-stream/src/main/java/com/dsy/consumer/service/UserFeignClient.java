package com.dsy.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dsy.consumer.entity.User;
import com.dsy.consumer.service.impl.FeignClientFallBack;

// @FeignClient(name="microservice-provider-user", url="http://localhost:8000/")
// @FeignClient(name="microservice-provider-user")
@FeignClient(name="microservice-provider-user", fallback=FeignClientFallBack.class)
public interface UserFeignClient {
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id);

}
