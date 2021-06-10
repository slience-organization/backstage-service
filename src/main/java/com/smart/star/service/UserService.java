package com.smart.star.service;

import com.smart.star.entity.CkUserEntity;
import org.springframework.stereotype.Service;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户业务接口
 */
public interface UserService {

    CkUserEntity getUserByPhone(String phone);

    Boolean register(String phone, String password);

    Boolean matchesPwd(String password, String encryptedPassword);

}
