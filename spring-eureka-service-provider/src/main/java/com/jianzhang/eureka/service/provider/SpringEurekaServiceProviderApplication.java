package com.jianzhang.eureka.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringEurekaServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServiceProviderApplication.class, args);
	}
}
