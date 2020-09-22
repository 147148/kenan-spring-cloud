package com.jd.kenan.spring.cloud.core.config;

import com.jd.kenan.spring.cloud.core.util.EnvironmentUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

@Configuration
@ConditionalOnProperty(prefix = "kenan.spring.cloud.base.config",name = "enable",havingValue = "true",matchIfMissing = true)
public class BaseConfig implements InitializingBean , EnvironmentAware {


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
