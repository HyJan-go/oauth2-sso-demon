package com.example.oauth2client.controller;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @description: 添加接口用于获取当前登录的用户信息
 * @author: HyJan
 * @create: 2020-07-31 10:14
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    /**
     * 这里测试
     * @param authentication
     * @return
     */
    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        log.info("authentication is {}",authentication);
        return authentication;
    }

    /**
     * 权限控制
     * @return
     */
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/auth/admin")
    public Object adminOauth() {
        return "Has admin auth";
    }
}
