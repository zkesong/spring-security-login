package com.zks.spring.security.login.components.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/11/1.
 */
@Component
public class TestTask {

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void startTimer(){
        System.out.println("current time" + System.currentTimeMillis());
    }
}
