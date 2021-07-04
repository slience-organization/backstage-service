package com.smart.star.mapper;

import com.smart.star.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author：yjw
 * @Date：2021/6/30
 * @Description: 系统角色接口
 */
@Mapper
@Repository
public interface SysRoleMapper {
    Boolean addRole(Map<String, Object> map);

    List<SysRoleEntity> getAllRoles();
}
