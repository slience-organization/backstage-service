package com.smart.star.service.serviceImpl;


import com.smart.star.config.model.MyUserDetails;
import com.smart.star.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yjw
 * @Description 自定义实现类，实现Spring Security 的 UserDetailsService接口，重写 loadUserByUsername方法，
 * 通过username（也就是账号或其他用户唯一标识）查询数据库返回UserDetails对象（包含用户和权限相关的信息）
 * @createTime 2021/6/26
 */
@Service("rbacService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //注入mapper，从数据库查询
        //用户基础信息
        MyUserDetails user = sysUserMapper.getUserByPhone(s);
        if(user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //用户的角色列表
        List<String> roleCodes = sysUserMapper.getRoleByUserId(user.getId());

        //用户的权限列表
        List<String> authorities = sysUserMapper.getAuthorityByRoleCodes(roleCodes);

        roleCodes.stream().map(rc -> "ROLE_" + rc).collect(Collectors.toList());

        authorities.addAll(roleCodes);

        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities)));

        return user;
    }

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetails userDetails = ((UserDetails) principal);

            //本次访问的资源
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(request.getRequestURI());

            //用户所有可访问的资源
            return userDetails.getAuthorities().contains(simpleGrantedAuthority);

        }
        return false;
    }

}
