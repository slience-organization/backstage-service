package com.smart.star.service.serviceImpl;

import com.smart.star.config.model.MyUserDetails;
import com.smart.star.mapper.SysUserMapper;
import com.smart.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public MyUserDetails getUserByPhone(String phone) {
        return sysUserMapper.getUserByPhone(phone);
    }

    @Override
    public Boolean register(String phone, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        return sysUserMapper.register(phone, encodedPassword);
    }

    @Override
    public Boolean matchesPwd(String password, String encryptedPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(passwordEncoder.matches(password, encryptedPassword)) {
            return true;
        }else {
            return false;
        }
    }

}
