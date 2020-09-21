package com.jd.kenan.spring.cloud.eureka.filter;

import com.jd.kenan.spring.cloud.eureka.util.EnvironmentUtil;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

import java.net.URI;

public class CustomEurekaServerIpFilter extends ClientFilter {

    private static final String HOST_STRING = "jd.spring.cloud.eureka.server.filter.host.string";

    private static final String SIGNATURE_HEADER_NAME = "jd.spring.cloud.eureka.server.filter.signature.header.name";

    private static final String SIGNATURE_HEADER_VALUE = "jd.spring.cloud.eureka.server.filter.signature.header.value";


    @Override
    public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {

        String hostString = EnvironmentUtil.ENV.getRequiredProperty(HOST_STRING);
        URI uri = clientRequest.getURI();

        if (!hostString.contains(uri.getHost())) {
            throw new ClientHandlerException("未过审核的host，请求被拒绝。");
        }

        return this.getNext().handle(clientRequest);
    }
}
