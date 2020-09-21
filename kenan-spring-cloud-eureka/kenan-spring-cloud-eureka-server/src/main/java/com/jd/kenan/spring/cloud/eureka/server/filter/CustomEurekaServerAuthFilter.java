package com.jd.kenan.spring.cloud.eureka.server.filter;


import com.jd.kenan.spring.cloud.eureka.server.util.EnvironmentUtil;
import com.sun.jersey.api.client.ClientHandlerException;

import javax.servlet.*;
import java.io.IOException;

public class CustomEurekaServerAuthFilter implements Filter {

    private static final String HOST_STRING = "jd.spring.cloud.eureka.server.filter.host.string";

    private static final String SIGNATURE_HEADER_NAME = "jd.spring.cloud.eureka.server.filter.signature.header.name";

    private static final String SIGNATURE_HEADER_VALUE = "jd.spring.cloud.eureka.server.filter.signature.header.value";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String hostString = EnvironmentUtil.ENV.getRequiredProperty(HOST_STRING);
        String host = servletRequest.getRemoteHost();

        System.out.println("custom eureka server auth filter doFilter execute ,request url is " + host);

        if (!hostString.contains(host)) {
            throw new ClientHandlerException("未过审核的host，请求被拒绝。");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
