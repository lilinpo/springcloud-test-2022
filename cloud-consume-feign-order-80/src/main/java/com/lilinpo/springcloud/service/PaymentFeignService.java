package com.lilinpo.springcloud.service;

import com.lilinpo.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Administrator
 * @Date 2022/7/23 18:15
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{recordId}")
    CommonResult getPaymentById(@PathVariable("recordId") long recordId);

    @GetMapping(value = "/payment/feign/timeout")
    String timeout();
}
