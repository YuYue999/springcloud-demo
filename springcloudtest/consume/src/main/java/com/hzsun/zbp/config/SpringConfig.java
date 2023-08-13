package com.hzsun.zbp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    @LoadBalanced //赋予RestTemplate轮询负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
