package com.bdwk.pinyougou.dao.config.datasource.multi;

/**
 * 放置数据源的核心类
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public DataSourceContextHolder() {
    }

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return (String)contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
