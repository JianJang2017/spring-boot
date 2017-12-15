package com.jianzhang.eureka.service.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Configuration
public class RestTemplateConfig {
    /**
     * 创建RestTemplate的spring bean 实例
     * 开启客户端负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
