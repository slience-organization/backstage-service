package com.smart.star.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.star.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yjw
 * @Description 重写AuthenticationFailureHandler接口的onAuthenticationFailure方法，
 *  实现自定登录认证失败后的处理方法，前后端分离的项目所以登录认证失败后响应Json数据格式而不是页面跳转
 * @createTime 2021/6/28
 * SimpleUrlAuthenticationFailureHandler默认实现了登录失败跳转页面
 */
@Component
public class MyAuthenticationOnFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Value("${spring.security.loginType}")//将配置属性绑定到成员变量上
    private String loginType;

    //springboot集成的Java对象与Json字符串之间的转换
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //如果是用JSON格式处理登录认证成功的响应
        if(loginType.equalsIgnoreCase("JSON")) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(Result.fail("请检查用户名或密码是否输入正确！")));//把Json数据写回客户端
        }else {
            response.setContentType("text/html;charset=UTF-8");
            super.onAuthenticationFailure(request, response, exception);
        }

    }
}
