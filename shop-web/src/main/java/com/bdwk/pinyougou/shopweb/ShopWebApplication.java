package com.bdwk.pinyougou.shopweb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.bdwk.pinyougou.shopweb","com.bdwk.pinyougou.exception"},
        exclude = {DataSourceAutoConfiguration.class})
@ImportResource(value = {"classpath:consumer-shopweb.xml"})
public class ShopWebApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShopWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopWebApplication.class);
    }
}
