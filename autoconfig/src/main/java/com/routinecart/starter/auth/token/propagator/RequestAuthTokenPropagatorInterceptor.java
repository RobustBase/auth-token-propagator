package com.routinecart.starter.auth.token.propagator;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class RequestAuthTokenPropagatorInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(RequestAuthTokenHeader.REQUEST_AUTH_TOKEN_HEADER,
                RequestAuthTokenHeaderContextHolder.getRequestAuthTokenHeader());
    }
}
