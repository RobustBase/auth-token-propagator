package com.routinecart.starter.auth.token.propagator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.routinecart.starter.auth.token.propagator.RequestAuthTokenHeader.REQUEST_AUTH_TOKEN_HEADER;

public class RequestUIDPropagatorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUID = httpServletRequest.getHeader(REQUEST_AUTH_TOKEN_HEADER);
        try {
            RequestAuthTokenHeaderContextHolder.setRequestUIDHeader(requestUID);
            chain.doFilter(request, response);
        } finally {
            RequestAuthTokenHeaderContextHolder.resetRequestUIDHeader();
        }
    }

    @Override
    public void destroy() {

    }
}
