package com.lilinpo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/7/23 20:47
 */
@Service
@DefaultProperties(defaultFallback = "globalTimeOutHandler")
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfoOk,id:" + id;
    }

    /*
        服务降级--------------------------------------------------------------------------------------------
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int timeOut = 5;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfoOk,id:" + id + "耗时:" + timeOut;
    }
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfoTimeOutHandler,id:" + id + "\t(；′⌒`)";
    }

    public String globalTimeOutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "\t global";
    }
    /*
        服务熔断---------------------------------------------------------------------------------------------
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 10) {
            throw new RuntimeException("id值小于10");
        }
        return "线程池" + Thread.currentThread().getName() + "\tpaymentCircuitBreaker,id:" + id;
    }
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "\tpaymentCircuitBreaker_fallback,id:" + id + "\t(；′⌒`)";
    }
}
