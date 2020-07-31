package com.example.oauth2client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description: 在接口配置权限时使用
 * @author: HyJan
 * @create: 2020-07-31 10:12
 **/
@Configuration
// 设置全局方法安全
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(101)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
}
