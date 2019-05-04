package com.bdwk.pinyougou.common.util;

import com.bdwk.pinyougou.common.enums.SellerStatus;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 负责各种判断的工具类
 */
public class Checker {
    /**
     * 判断 2个状态是否相同
     * @param sellerStatus
     * @param status
     * @return
     */
    public static boolean eq(SellerStatus sellerStatus,String status){
        return sellerStatus.getStatus().equals(status);
    }

    public static boolean isNull(Serializable... serializable){
        if(serializable.length<=0){
            return true;
        }else{
            if(serializable.length==1){
                return null==serializable[0];
            }
            return Arrays.asList(serializable).contains(null);
        }
    }
    public static boolean isNotNull(Serializable... serializable){
        return !isNull(serializable);
    }
    public static boolean isBlank(String... s){
        if(s.length<=0){
            return true;
        }else {
            if(s.length==1){
                return null==s[0] || s[0].length()<=0;
            }
            boolean ret=false;
            for (String el:s){
                if(null==el || el.length()<=0){
                    ret=true;
                    break;
                }
            }
            return ret;
        }
    }
    public static boolean isNotBlank(String... s){
        return !isBlank(s);
    }

}
