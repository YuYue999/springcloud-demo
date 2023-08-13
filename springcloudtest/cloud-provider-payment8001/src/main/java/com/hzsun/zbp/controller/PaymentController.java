package com.hzsun.zbp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {


    /**
     *
     * @return
     */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String payment(){
       return "8001支付成功";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/lb",method = RequestMethod.GET)
    public String loadBalanced(){
        return "8001支付成功";
    }
}
