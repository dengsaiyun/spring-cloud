package com.dsy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dsy.consumer.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
	}
	
	@GetMapping("/log-instance")
	public void logUserInstance() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		// 打印当前选择的时哪个节点
		log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}

}
