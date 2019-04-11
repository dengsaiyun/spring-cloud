package com.dsy.consumer.test;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import com.dsy.consumer.config.RibbonConfiguration;

@Configuration
@RibbonClient(name="microservice-provider-user", configuration=RibbonConfiguration.class)
public class TestConfiguration {

}
