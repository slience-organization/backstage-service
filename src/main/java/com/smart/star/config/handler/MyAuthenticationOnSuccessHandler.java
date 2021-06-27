package com.smart.star.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.star.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yjw
 * @Description 重写AuthenticationSuccessHandler接口的onAuthenticationSuccess方法，
 *  实现自定登录认证成功后的处理方法，前后端分离的项目所以登录认证成功后响应Json数据格式而不是页面跳转
 * @createTime 2021/6/27
 * SavedRequestAwareAuthenticationSuccessHandler //可以记录上一次登录请求地址
 */
@Component
public class MyAuthenticationOnSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${spring.security.loginType}")//将配置属性绑定到成员变量上
    private String loginType;

    //springboot集成的Java对象与Json字符串之间的转换
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //如果是用JSON格式处理登录认证成功的响应
        if(loginType.equalsIgnoreCase("JSON")) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(Result.success()));//把Json数据写回客户端
        }else {
            //如果不是，会帮我们跳转到上一次请求的页面
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

}
