package com.bdwk.pinyougou.config.other;

/*@Configuration*/
public class MybatisConfig {
    /*@Value("${mybatis-plus.mapper-locations}")
    private String mapperLocationPattern;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));
        return sqlSessionFactoryBean.getObject();
    }
*/
}
