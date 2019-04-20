package com.bdwk.pinyougou.sellergoods;

import cn.stylefeng.roses.core.config.WebAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan("com.bdwk.pinyougou.mapper")
@MapperScan("com.bdwk.pinyougou.mapper")
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
