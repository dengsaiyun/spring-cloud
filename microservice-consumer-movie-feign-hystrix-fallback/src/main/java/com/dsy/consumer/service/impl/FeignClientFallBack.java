package com.dsy.consumer.service.impl;

import org.springframework.stereotype.Component;

import com.dsy.consumer.entity.User;
import com.dsy.consumer.service.UserFeignClient;

@Component
public class FeignClientFallBack implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setUsername("默认用户");
		return user;
	}

}
