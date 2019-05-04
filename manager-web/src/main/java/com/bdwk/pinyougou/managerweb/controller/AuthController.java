package com.bdwk.pinyougou.managerweb.controller;

import com.bdwk.pinyougou.common.http.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthController extends BaseController{

    /**
     * 获取已认证的用户名
     * @return
     */
    @RequestMapping("/authName")
    public R<Map<String,String>> loginUserName(){
        Map<String,String> map=new HashMap<>();
        map.put("authenticationName",getAuthedId());
        return R.create(map);
    }
}
