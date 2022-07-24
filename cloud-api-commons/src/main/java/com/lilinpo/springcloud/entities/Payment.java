package com.lilinpo.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Administrator
 * @Date 2022/7/22 23:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long recordId;
    private String serial;
}