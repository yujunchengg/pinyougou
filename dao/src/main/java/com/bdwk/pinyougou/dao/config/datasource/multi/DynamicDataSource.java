package com.bdwk.pinyougou.dao.config.datasource.multi;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 自动进行数据源切换的类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(){

    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
