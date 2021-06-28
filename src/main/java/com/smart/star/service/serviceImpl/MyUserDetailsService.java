package com.smart.star.service.serviceImpl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yjw
 * @Description 自定义实现类，实现Spring Security 的 UserDetailsService接口，重写 loadUserByUsername方法，
 * 通过username（也就是账号或其他用户唯一标识）查询数据库返回UserDetails对象（包含用户和权限相关的信息）
 * @createTime 2021/6/26
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //注入mapper，从数据库查询
        //用户基础信息

        //用户的角色列表

        //用户的权限列表



        return null;
    }

}
