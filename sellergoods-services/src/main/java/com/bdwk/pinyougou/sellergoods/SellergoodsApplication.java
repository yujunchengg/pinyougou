package com.bdwk.pinyougou.sellergoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(scanBasePackages = {"com.bdwk.pinyougou.dao"})
@ImportResource(value = {"classpath:provider-sellergoods.xml"})
public class SellergoodsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SellergoodsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SellergoodsApplication.class);
    }
}
