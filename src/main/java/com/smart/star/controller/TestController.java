package com.smart.star.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: 测试控制器
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {

    @GetMapping("/say")
    @ApiOperation("Hello Word 测试")
    public String test() {
        System.out.println("调用了/test/say");
        return "hello word";
    }

}
