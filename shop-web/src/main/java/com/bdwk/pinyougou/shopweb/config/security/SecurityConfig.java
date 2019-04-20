package com.bdwk.pinyougou.shopweb.config.security;

import com.bdwk.pinyougou.shopweb.config.security.handler.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * security config
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig<configureGlobalSecurity> extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.html","/css/**","/img/**","/js/**","/plugins/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_SHOP')")
                .and()
                .formLogin()
                .loginPage("/login.html")   //登录页路径
                .loginProcessingUrl("/shop/authentication")
                .successForwardUrl("/admin/index.html")
                .defaultSuccessUrl("/admin/index.html")
                //.successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();    //关闭csrf
        //允许页面iframe嵌套
        http.headers().frameOptions().disable();
    }
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        // 以前的方式配置
        // auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("shop").password(new BCryptPasswordEncoder().encode("shop")).roles("ROLE_SHOP");
    }
}
