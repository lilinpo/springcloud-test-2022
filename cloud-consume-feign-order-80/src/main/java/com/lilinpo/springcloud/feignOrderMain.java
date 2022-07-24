package com.lilinpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Administrator
 * @Date 2022/7/23 18:09
 */
@SpringBootApplication
@EnableFeignClients
public class feignOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(feignOrderMain.class,args);
    }
}
