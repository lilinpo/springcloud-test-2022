package com.lilinpo.springcloud.service.impl;

import com.lilinpo.springcloud.dao.PaymentDao;
import com.lilinpo.springcloud.entities.Payment;
import com.lilinpo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2022/7/22 21:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long recordId) {
        return paymentDao.getPaymentById(recordId);
    }
}
