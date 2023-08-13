package com.hzsun.zbp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@RestController
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;

    private final static String paymentUrl="http://localhost:8001/";
//    private final static String paymentUrl="http://CLOUD-PROVIDER-PAYMENT/";

    @GetMapping("consume")
    public String consume() {
        String forObject = restTemplate.getForObject(paymentUrl + "payment/get", String.class);
        return forObject;
    }
}
