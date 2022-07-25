package com.lilinpo.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.lilinpo.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2022/7/25 20:47
 */
@EnableBinding(Source.class)  // 定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output;   // 消息发送管道

    public String send() {
        String serial = IdUtil.fastUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***************" + serial);
        return serial;
    }
}
