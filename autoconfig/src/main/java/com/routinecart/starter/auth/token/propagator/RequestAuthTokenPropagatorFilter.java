package com.routinecart.starter.auth.token.propagator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.routinecart.starter.auth.token.propagator.RequestAuthTokenHeader.REQUEST_AUTH_TOKEN_HEADER;

public class RequestAuthTokenPropagatorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestAuthToken = httpServletRequest.getHeader(REQUEST_AUTH_TOKEN_HEADER);
        try {
            RequestAuthTokenHeaderContextHolder.setRequestAuthTokenHeader(requestAuthToken);
            chain.doFilter(request, response);
        } finally {
            RequestAuthTokenHeaderContextHolder.resetRequestAuthTokenHeader();
        }
    }

    @Override
    public void destroy() {

    }
}
