package com.bdwk.pinyougou.managerweb.controller;

import com.bdwk.pinyougou.common.http.R;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/index")
@RestController
public class IndexController {

    /**
     * 获取已认证的用户名
     * @return
     */
    @RequestMapping("/authName")
    public R<Map<String,String>> loginUserName(){
        String name=SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,String> map=new HashMap<>();
        map.put("authenticationName",name);
        return R.create(map);
    }
}
