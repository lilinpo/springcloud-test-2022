package com.lilinpo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Administrator
 * @Date 2022/7/22 23:04
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //给restTemplate负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
