package com.jd.kenan.spring.cloud.eureka.server.config;

import com.jd.kenan.spring.cloud.eureka.server.filter.CustomEurekaServerAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class CustomEurekaServerConfig {

    @Bean
    @Description("自定义身份验证filter")
    public FilterRegistrationBean<CustomEurekaServerAuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomEurekaServerAuthFilter> registration = new FilterRegistrationBean<>(new CustomEurekaServerAuthFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }


}
