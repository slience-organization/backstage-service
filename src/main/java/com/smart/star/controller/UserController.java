package com.smart.star.controller;

import com.smart.star.entity.CkUserEntity;
import com.smart.star.service.UserService;
import com.smart.star.util.JwtUtils;
import com.smart.star.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 用户业务控制器
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone",value = "手机号"),
            @ApiImplicitParam(name = "password",value = "密码")})
    public Result register(@RequestParam String phone, @RequestParam String password) {
        CkUserEntity user = userService.getUserByPhone(phone);
        if(user!=null) {
            return Result.fail("用户已存在！");
        }else {
            Boolean res = userService.register(phone, password);
            if(res){
                return Result.success();
            }else {
                return Result.fail("注册失败！");
            }
        }
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone",value = "手机号"),
            @ApiImplicitParam(name = "password",value = "密码")})
    public Result login(@RequestBody Map<String,String> params) {
        String phone = params.get("phone");
        String password = params.get("password");
        CkUserEntity user = userService.getUserByPhone(phone);
        if(user != null) {
            Boolean b = userService.matchesPwd(password, user.getPassword());
            if(b) {
                Map<String,String> map = new HashMap<>();
                map.put("userId", user.getId());
                String jwt = JwtUtils.generateToken(map);
                Map<String,Object> res = new HashMap<>();
                res.put("token", jwt);
                res.put("user", user);
                return Result.success(res);
            }
            return Result.fail("密码错误！");
        }else {
            return Result.fail("用户不存在！");
        }
    }

}
