package com.dsy.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dsy.consumer.entity.User;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id);

}

@Slf4j
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {

			@Override
			public User findById(Long id) {
				log.info("fallback; reason was:", cause);
				User user = new User();
				// 针对不同的异常, 返回不同的回退结果
				if (cause instanceof IllegalArgumentException) {
					user.setId(-1L);
				} else {
					user.setId(-2L);
				}
				user.setUsername("默认用户");
				return user;
			}
		};
	}

}
