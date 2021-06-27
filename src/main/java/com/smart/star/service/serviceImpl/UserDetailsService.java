package com.smart.star.service.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yjw
 * @Description 自定义实现类，实现Spring Security 的 UserDetailsService接口，重写 loadUserByUsername方法，自定义用户认证逻辑
 * @createTime 2021/6/26
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //查询用户

        return null;
    }

}
