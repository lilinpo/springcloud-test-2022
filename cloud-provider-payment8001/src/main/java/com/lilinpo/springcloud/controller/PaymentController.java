package com.lilinpo.springcloud.controller;

import com.lilinpo.springcloud.entities.CommonResult;
import com.lilinpo.springcloud.entities.Payment;
import com.lilinpo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/7/22 21:45
 */
@Controller
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    @ResponseBody
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "success" + serverPort, result);
        } else {
            return new CommonResult(444, "fail");
        }
    }

    @GetMapping(value = "/payment/get/{recordId}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("recordId") long recordId) {
        Payment payment = paymentService.getPaymentById(recordId);
        log.info("插入结果" + payment + "123");
        if (payment != null) {
            return new CommonResult(200, "success" + serverPort, payment);
        } else {
            return new CommonResult(444, "fail");
        }
    }

    @GetMapping(value = "/payment/discovery")
    @ResponseBody
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return new CommonResult(200, "success");
    }

    @GetMapping(value = "/payment/feign/timeout")
    @ResponseBody
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
