package com.bdwk.pinyougou.dao.util;


import org.springframework.util.StringUtils;

public class MapperUtil {

    public static boolean isBlank(String str){
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
