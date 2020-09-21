package com.jd.kenan.spring.cloud.eureka.config;

import com.jd.kenan.spring.cloud.eureka.filter.CustomEurekaServerIpFilter;
import com.jd.kenan.spring.cloud.eureka.util.EnvironmentUtil;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.Collections;

@Configuration
public class CustomEurekaServerConfig implements EnvironmentAware, InitializingBean {

    @Bean
    @Description("自定义身份验证filter")
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {

        DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs = new DiscoveryClient.DiscoveryClientOptionalArgs();
        discoveryClientOptionalArgs.setAdditionalFilters(Collections.singletonList(new CustomEurekaServerIpFilter()));
        return discoveryClientOptionalArgs;

    }

    /**
     * 设置环境变量
     */
    @Override
    public void setEnvironment(@NonNull Environment environment) {
        EnvironmentUtil.setEnvironment(environment);
    }

    /**
     * 环境变量参数校验
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(EnvironmentUtil.ENV, "环境变量不能为空");
    }
}
