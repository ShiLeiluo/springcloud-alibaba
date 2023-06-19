package com.fox.alibaba.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-06-19 15:44
 * @version 1.0
 */
@Configuration
public class FilterContextConfig {
	@Bean
	public FilterRegistrationBean<CommonFilter> sentinelFilterRegistration() {
		FilterRegistrationBean<CommonFilter> registration = new FilterRegistrationBean<CommonFilter>();
		registration.setFilter(new CommonFilter());
		registration.addUrlPatterns("/*");
// 入口资源关闭聚合 
		registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
		registration.setName("sentinelFilter");
		registration.setOrder(1);
		return registration;
	}
}