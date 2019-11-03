package com.routinecart.starter.auth.token.propagator.autoconfig;

import com.routinecart.starter.auth.token.propagator.RequestAuthTokenPropagatorFilter;
import com.routinecart.starter.auth.token.propagator.RequestAuthTokenPropagatorInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.Integer.MAX_VALUE;

@Configuration
@ConditionalOnProperty(
        prefix = "com.routinecart.starter.auth.token.propagator",
        name = "enabled",
        havingValue = "true", matchIfMissing = true
)
public class RequestAuthTokenPropagatorAutoConfiguration {
    @Bean
    public FilterRegistrationBean requestUIDPropagatorFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RequestAuthTokenPropagatorFilter());
        filterRegistrationBean.setOrder(MAX_VALUE);
        return filterRegistrationBean;
    }

    @Bean
    @ConditionalOnBean
    public RequestAuthTokenPropagatorInterceptor requestUIDPropagatorInterceptor() {
        return new RequestAuthTokenPropagatorInterceptor();
    }
}
