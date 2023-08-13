package com.hzsun.zbp.controller;

import com.hzsun.zbp.entity.Student;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String payment() {
        Student student = new Student();
        return "8002支付成功";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/lb",method = RequestMethod.GET)
    public String loadBalanced(){
        return "8002支付成功";
    }

    /**
     * 服务发现，用来获取注册在eureka上的微服务的信息（ip,端口等等信息）
     * @return
     */
    @GetMapping("discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();//获取注册在eureka上的微服务名称列表
        for (String service : services) {
            System.out.println(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            String str = instance.getServiceId() + "\t" + instance.getInstanceId() + "\t" + instance.getHost() +
                    "\t" + instance.getPort() + "\t"
                    + instance.getUri();
            System.out.println(str);
        }
        return this.discoveryClient;
    }
}
