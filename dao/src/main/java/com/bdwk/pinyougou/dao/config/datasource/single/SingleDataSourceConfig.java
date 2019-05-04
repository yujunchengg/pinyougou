package com.bdwk.pinyougou.dao.config.datasource.single;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.bdwk.pinyougou.dao.config.properties.DruidProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.bdwk.pinyougou.dao.datascope.DataScopeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 多数据源配置
 *
 * @author yujuncheng
 * @Date 2019/5/2 16:18
 */
@Configuration
@ConditionalOnProperty(prefix = "bdwk.muti-datasource", name = "open", havingValue = "false", matchIfMissing = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"com.bdwk.pinyougou.dao.mapper"})
@Slf4j
public class SingleDataSourceConfig {
    SingleDataSourceConfig(){
        log.info("SingleDataSourceConfig is excuted..............");
    }
    /**
     * druid配置
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidProperties druidProperties() {
        return new DruidProperties();
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        return paginationInterceptor;
    }

    /**
     * 数据范围mybatis插件
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor=new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

}

