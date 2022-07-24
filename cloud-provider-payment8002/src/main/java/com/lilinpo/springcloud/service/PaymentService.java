package com.lilinpo.springcloud.service;

import com.lilinpo.springcloud.entities.Payment;

/**
 * @Author Administrator
 * @Date 2022/7/22 21:41
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long recordId);
}
