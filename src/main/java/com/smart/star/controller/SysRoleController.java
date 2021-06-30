package com.smart.star.controller;

import com.smart.star.mapper.SysRoleMapper;
import com.smart.star.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：yjw
 * @Date：2021/6/30
 * @Description: 系统角色控制器
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class SysRoleController {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @PostMapping("/addRole")
    @ApiOperation("添加角色")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "角色名称"),
            @ApiImplicitParam(name = "code",value = "角色编码"), @ApiImplicitParam(name = "remark",value = "描述")})
    public Result addRole(@RequestBody Map<String,String> params) {
        String name = params.get("name");
        String code = params.get("code");
        String remark = params.get("remark");
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("code", code);
        map.put("remark", remark);
        Boolean b = sysRoleMapper.addRole(map);
        if(b) {
            return Result.success("操作成功");
        }
        return Result.fail("操作失败");
    }

}
