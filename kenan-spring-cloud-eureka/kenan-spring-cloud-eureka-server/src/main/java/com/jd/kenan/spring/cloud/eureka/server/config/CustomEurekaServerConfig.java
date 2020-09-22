package com.jd.kenan.spring.cloud.eureka.server.config;

import com.jd.kenan.spring.cloud.eureka.server.filter.CustomEurekaServerAuthFilter;
import com.jd.kenan.spring.cloud.eureka.server.util.EnvironmentUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

@Configuration
public class CustomEurekaServerConfig implements EnvironmentAware, InitializingBean {

    @Bean
    @Description("自定义身份验证filter")
    public FilterRegistrationBean<CustomEurekaServerAuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomEurekaServerAuthFilter> registration = new FilterRegistrationBean<>(new CustomEurekaServerAuthFilter());
        registration.addUrlPatterns("/*");
        return registration;
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
