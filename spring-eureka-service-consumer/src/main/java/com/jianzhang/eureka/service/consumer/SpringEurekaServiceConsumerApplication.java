package com.jianzhang.eureka.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringEurekaServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServiceConsumerApplication.class, args);
	}
}
