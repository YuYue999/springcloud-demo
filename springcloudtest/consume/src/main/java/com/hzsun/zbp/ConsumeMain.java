package com.hzsun.zbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import rule.RuleConfig;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = RuleConfig.class)
public class ConsumeMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeMain.class);
    }
}
