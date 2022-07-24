package com.lilinpo.springcloud.dao;

import com.lilinpo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Administrator
 * @Date 2022/7/22 21:29
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("recordId") Long recordId);
}
