package com.jd.kenan.spring.cloud.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
@ConditionalOnProperty(prefix = "kenan.spring.cloud.application.start.fail.listener",name = "enable",havingValue = "true",matchIfMissing = true)
public class ApplicationStartFailListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationFailedEvent event) {
        //TODO 后期改成发送邮件
        System.out.println("程序启动失败。。。。。。。");
    }
}
