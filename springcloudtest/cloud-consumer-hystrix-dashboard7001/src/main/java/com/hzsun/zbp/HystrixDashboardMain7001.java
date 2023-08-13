package com.hzsun.zbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @auther zzyy
 * @create 2020-02-20 22:02
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain7001
{
    public static void main(String[] args) {
            SpringApplication.run(HystrixDashboardMain7001.class, args);
    }
}
