package com.routinecart.starter.auth.token.propagator;

import org.springframework.core.NamedThreadLocal;

public class RequestAuthTokenHeaderContextHolder {
    private static final ThreadLocal<String> requestAuthTokenHeaderContextHolder =
            new NamedThreadLocal<>("Request Auth Token Header");

    private RequestAuthTokenHeaderContextHolder() {
    }

    static void setRequestAuthTokenHeader(String requestAuthTokenHeader) {
        requestAuthTokenHeaderContextHolder.set(requestAuthTokenHeader);
    }

    static String getRequestAuthTokenHeader() {
        return requestAuthTokenHeaderContextHolder.get();
    }

    static void resetRequestAuthTokenHeader() {
        requestAuthTokenHeaderContextHolder.remove();
    }
}
