package com.hzsun.zbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther zzyy
 * @create 2020-02-25 16:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain6004
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain6004.class, args);
    }
}
