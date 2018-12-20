package com.zks.spring.security.login.service.impl;

import com.zks.spring.security.login.components.mq.AmqMessageProducer;
import com.zks.spring.security.login.service.JmService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kesongzeng on 2018/12/20.
 */
public class JmServiceImpl implements JmService {

    @Autowired
    private AmqMessageProducer producer;

    @Override
    public String sendMessage(String message) {
        producer.sendMessage(message);
        return "success";
    }
}
