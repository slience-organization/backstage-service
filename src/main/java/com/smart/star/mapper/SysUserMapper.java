package com.smart.star.mapper;

import com.smart.star.config.model.MyUserDetails;
import com.smart.star.entity.SysRoleEntity;
import com.smart.star.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户管理接口
 */
@Mapper
@Repository
public interface SysUserMapper {

    /**
     * @Description
     * @Param [id]
     * @return com.smart.star.entity.CkUserEntity
     **/
    SysUserEntity getUserById(String id);

    /**
     * @Description
     * @Param [phone, password]
     * @return java.lang.Boolean
     **/
    Boolean addUser(String phone, String password);

    MyUserDetails getUserByPhone(String phone);

    List<String> getRoleByUserId(String userId);

    List<String> getAuthorityByRoleCodes(List<String> roleCodes);

    List<SysUserEntity> getAllUsers();

}
