package com.bdwk.pinyougou.managerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.bdwk.pinyougou.managerweb","com.bdwk.pinyougou.exception"},
        exclude = {DataSourceAutoConfiguration.class})
@ImportResource(value = {"classpath:consumer-managerweb.xml"})
@EnableTransactionManagement
public class ManagerWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManagerWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplication.class);
    }
}
