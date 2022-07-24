package com.lilinpo.springcloud.controller;

import com.lilinpo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/7/23 20:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{recordId}")
    public String paymentInfoOk(@PathVariable("recordId") Integer recordId) {
        String result = paymentService.paymentInfoOk(recordId);
        log.info("********result" + result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeOut/{recordId}")
    public String paymentInfoTimeOut(@PathVariable("recordId") Integer recordId) {
        String result = paymentService.paymentInfoTimeOut(recordId);
        log.info("********result" + result);
        return result;
    }
    @GetMapping(value = "/payment/hystrix/circuitBreaker/{recordId}")
    public String paymentCircuitBreaker(@PathVariable("recordId") Integer recordId) {
        String result = paymentService.paymentCircuitBreaker(recordId);
        log.info("********result" + result);
        return result;
    }
}
