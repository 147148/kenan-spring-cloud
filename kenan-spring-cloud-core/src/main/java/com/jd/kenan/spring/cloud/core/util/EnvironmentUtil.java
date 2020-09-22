package com.jd.kenan.spring.cloud.core.util;

import org.springframework.core.env.Environment;

public final class EnvironmentUtil {

    public static Environment ENV;

    public static void setEnvironment(Environment environment) {
        ENV = environment;
    }
}
