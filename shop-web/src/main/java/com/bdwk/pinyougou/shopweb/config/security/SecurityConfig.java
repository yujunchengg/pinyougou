package com.bdwk.pinyougou.shopweb.config.security;

import com.bdwk.pinyougou.shopweb.config.security.handler.AuthenticationSuccessHandler;
import com.bdwk.pinyougou.shopweb.config.security.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security config
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfig<configureGlobalSecurity> extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private UserDetailService userDetailService;
    /**
     * 配置自定义的用于认证的userDetailService
     * @return
     */
    //@Bean
    UserDetailService userDetailService(){
        return new UserDetailService();
    }

    /**
     * 没有passwordEncoder会抛java.lang.IllegalArgumentException:
     *      There is no PasswordEncoder mapped for the id "null"
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.html","/register.html","/seller/add","/css/**","/img/**","/js/**","/plugins/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('SELLER')")
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
        //auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("shop").password(new BCryptPasswordEncoder().encode("shop")).roles("SHOP");
        log.info("shop-web.SecurityConfig.configureGlobalSecurity is executed.........................");
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
