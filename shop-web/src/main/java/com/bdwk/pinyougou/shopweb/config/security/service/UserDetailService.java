package com.bdwk.pinyougou.shopweb.config.security.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.enums.SellerStatus;
import com.bdwk.pinyougou.entity.pojo.TbSeller;
import com.bdwk.pinyougou.sellergoods.service.ISellerService;
import com.bdwk.pinyougou.common.util.Checker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * spring-security所需的一个认证类
 * 该类通过实现UserDetailsService接口，实现loadUserByUsername方法进行认证
 */
@Slf4j
@Component
public class UserDetailService implements UserDetailsService {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20903")
    private ISellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetailService is executed.............");
        //权限的集合
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        TbSeller seller = sellerService.getById(username);
        if(null!=seller && Checker.eq(SellerStatus.HAS_CHECKED,seller.getStatus())){
            return new User(username,seller.getPassword(),authorities);
        }else {
            return null;
        }
    }
}
