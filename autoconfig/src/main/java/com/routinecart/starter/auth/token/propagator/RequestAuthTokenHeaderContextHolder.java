package com.routinecart.starter.auth.token.propagator;

import org.springframework.core.NamedThreadLocal;

public class RequestAuthTokenHeaderContextHolder {
    private static final ThreadLocal<String> requestAuthTokenHeaderContextHolder = new NamedThreadLocal<>("Request Auth Token Header");

    private RequestAuthTokenHeaderContextHolder() {
    }

    static void setRequestUIDHeader(String requestUIDHeader) {
        requestAuthTokenHeaderContextHolder.set(requestUIDHeader);
    }

    static String getRequestUIDHeader() {
        return requestAuthTokenHeaderContextHolder.get();
    }

    static void resetRequestUIDHeader() {
        requestAuthTokenHeaderContextHolder.remove();
    }
}
