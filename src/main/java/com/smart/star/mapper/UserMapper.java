package com.smart.star.mapper;

import com.smart.star.entity.CkUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户管理DAO层
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * @Description
     * @Param [id]
     * @return com.smart.star.entity.CkUserEntity
     **/
    CkUserEntity getUserById(String id);

    /**
     * @Description
     * @Param [phone, password]
     * @return java.lang.Boolean
     **/
    Boolean register(String phone, String password);

    CkUserEntity getUserByPhone(String phone);

}
