package com.bdwk.pinyougou.dao.config.datasource.multi.annotation;

import java.lang.annotation.*;

/**
 * 标识数据源的注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataSource {
    String name() default "";
}
