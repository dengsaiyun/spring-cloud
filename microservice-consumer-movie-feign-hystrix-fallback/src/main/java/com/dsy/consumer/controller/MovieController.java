package com.dsy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dsy.consumer.entity.User;
import com.dsy.consumer.service.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	/**
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return restTemplate.getForObject("http://localhost:8000/" + id, User.class);
	}
	*/

}
