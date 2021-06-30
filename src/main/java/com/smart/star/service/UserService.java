package com.smart.star.service;

import com.smart.star.config.model.MyUserDetails;
import com.smart.star.entity.SysUserEntity;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户业务接口
 */
public interface UserService {

    MyUserDetails getUserByPhone(String phone);

    Boolean register(String phone, String password);

    Boolean matchesPwd(String password, String encryptedPassword);

}
