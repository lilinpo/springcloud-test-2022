package com.lilinpo.springcloud.controller;

import com.lilinpo.springcloud.entities.CommonResult;
import com.lilinpo.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2022/7/23 18:20
 */
@Controller
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{recordId}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("recordId") long recordId) {
        return paymentFeignService.getPaymentById(recordId);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    @ResponseBody
    public String timeout() {
        return paymentFeignService.timeout();
    }
}
