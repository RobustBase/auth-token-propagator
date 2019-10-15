package com.routinecart.starter.auth.token.propagator.autoconfig;

import com.routinecart.starter.auth.token.propagator.RequestUIDPropagatorFilter;
import com.routinecart.starter.auth.token.propagator.RequestUIDPropagatorInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.Integer.MAX_VALUE;

@Configuration
@ConditionalOnProperty(
        prefix = "routinecart.request.uid.propagator",
        name = "enabled",
        havingValue = "true", matchIfMissing = true
)
public class RequestUIDPropagatorAutoConfiguration {
    @Bean
    public FilterRegistrationBean requestUIDPropagatorFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RequestUIDPropagatorFilter());
        filterRegistrationBean.setOrder(MAX_VALUE);
        return filterRegistrationBean;
    }

    @Bean
    @ConditionalOnBean
    public RequestUIDPropagatorInterceptor requestUIDPropagatorInterceptor() {
        return new RequestUIDPropagatorInterceptor();
    }
}
