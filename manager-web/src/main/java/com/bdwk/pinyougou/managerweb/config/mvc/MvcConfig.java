package com.bdwk.pinyougou.managerweb.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc  config
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //todo 注入一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
