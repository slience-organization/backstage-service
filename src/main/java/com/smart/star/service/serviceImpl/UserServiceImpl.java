package com.smart.star.service.serviceImpl;

import com.smart.star.entity.CkUserEntity;
import com.smart.star.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Override
    public CkUserEntity getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public Boolean register(String phone, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        return userMapper.register(phone, encodedPassword);
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
