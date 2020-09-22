package com.jd.kenan.spring.cloud.core.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class ApplicationStartSuccessListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {

        //TODO 后期改成发送邮件
        System.out.println("程序启动成功。。。。。。。");
    }
}
