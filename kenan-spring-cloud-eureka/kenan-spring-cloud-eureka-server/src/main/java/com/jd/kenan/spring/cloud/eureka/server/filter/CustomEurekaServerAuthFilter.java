package com.jd.kenan.spring.cloud.eureka.server.filter;


import com.jd.kenan.spring.cloud.eureka.server.util.EnvironmentUtil;

import javax.servlet.*;
import java.io.IOException;

public class CustomEurekaServerAuthFilter implements Filter {

    private static final String HOST_STRING = "jd.spring.cloud.eureka.server.filter.host.string";

    private static final String NAME_STRING = "jd.spring.cloud.eureka.server.filter.name.string";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        authEurekaClient(servletRequest);

        filterChain.doFilter(servletRequest, servletResponse);
    }


    /**
     * eureka client的注册认证，目前只认证 host 以及 server name
     */
    private void authEurekaClient(ServletRequest servletRequest) throws ServletException {

        String hostString = EnvironmentUtil.ENV.getRequiredProperty(HOST_STRING);
        String nameString = EnvironmentUtil.ENV.getRequiredProperty(NAME_STRING);
        String host = servletRequest.getRemoteHost();
        String name = servletRequest.getServerName();

        System.out.println("custom eureka server auth filter doFilter execute ,request url is "
                + host + " server name " + name);

        if (!hostString.contains(host) && nameString.contains(name)) {
            throw new ServletException("未过审核的host或者server name，请求被拒绝。");
        }
    }
}
