package com.example.oauth2jwtserver.service;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description: 用户服务类，必须实现 userDetailService这个接口
 * @author: HyJan
 * @create: 2020-07-31 11:24
 **/
@Service
public class UserService implements UserDetailsService {

    private List<User> users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用来验证用户登录是否通过的一个接口
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> collect = users.stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(collect)){
            return collect.get(0);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    /**
     * @PostConstruct 在spring初始化完成后就会执行的一个注解
     * 用来模拟数据库的少量数据
     */
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        users = new ArrayList<>();
        users.add(new User("Lily",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        users.add(new User("John",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        users.add(new User("HyJan",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        users.add(new User("Jerry",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        users.add(new User("chazi",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
    }
}
