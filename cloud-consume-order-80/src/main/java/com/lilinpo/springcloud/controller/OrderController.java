package com.lilinpo.springcloud.controller;

import com.lilinpo.springcloud.entities.CommonResult;
import com.lilinpo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2022/7/22 23:03
 */
@Controller
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    // public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @GetMapping("/consumer/payment/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{recordId}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("recordId") long recordId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + recordId, CommonResult.class);
    }
}
