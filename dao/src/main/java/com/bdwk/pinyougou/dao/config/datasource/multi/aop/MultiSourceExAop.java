package com.bdwk.pinyougou.dao.config.datasource.multi.aop;

import com.bdwk.pinyougou.dao.config.datasource.multi.DataSourceContextHolder;
import com.bdwk.pinyougou.dao.config.datasource.multi.annotation.DataSource;
import com.bdwk.pinyougou.dao.config.properties.MutiDataSourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

@Aspect
@Slf4j
public class MultiSourceExAop implements Ordered {

    @Autowired
    private MutiDataSourceProperties mutiDataSourceProperties;

    public MultiSourceExAop() {
    }

    @Pointcut("@annotation(com.bdwk.pinyougou.dao.config.datasource.multi.annotation.DataSource)")
    private void cut() {
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = null;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        } else {
            methodSignature = (MethodSignature)signature;
            Object target = point.getTarget();
            Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            DataSource datasource = (DataSource)currentMethod.getAnnotation(DataSource.class);
            if (datasource != null) {
                DataSourceContextHolder.setDataSourceType(datasource.name());
                log.debug("设置数据源为：" + datasource.name());
            } else {
                DataSourceContextHolder.setDataSourceType(this.mutiDataSourceProperties.getDataSourceNames()[0]);
                log.debug("设置数据源为：dataSourceCurrent");
            }

            Object var7;
            try {
                var7 = point.proceed();
            } finally {
                log.debug("清空数据源信息！");
                DataSourceContextHolder.clearDataSourceType();
            }

            return var7;
        }
    }

    public int getOrder() {
        return 1;
    }
}
