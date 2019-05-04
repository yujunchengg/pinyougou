package com.bdwk.pinyougou.managerweb.controller;

import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
    //调用dubbo发布的服务的url
    protected static final String DUBBO_REFERENCE_URL="dubbo://127.0.0.1:20903";
    //用dubbo发布的服务的版本
    protected static final String DUBBO_REFERENCE_VERSION="1.0.0";

    /**
     * 获取已经认证的用户id
     * @return
     */
    protected String getAuthedId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
