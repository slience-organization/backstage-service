package com.smart.star.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Calendar;
import java.util.Map;

/**
 * @Author：yjw
 * @Date：2021/6/10
 * @Description: Jwt(Token)工具类
 */
public class JwtUtils {

    private static final String signature = "!2kljsdf#kj..J@#*jkj&";

    public static String generateToken(Map<String,String> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);

        //创建一个jwt builder
        JWTCreator.Builder jwt = JWT.create();
        //payload
        for (Map.Entry<String,String> entry: map.entrySet()) {
            jwt.withClaim(entry.getKey(),entry.getValue());
        }
        String token = jwt.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC512(signature));
        return token;
    }

    public static DecodedJWT verifyToken(String jwt) {
        return JWT.require(Algorithm.HMAC512(signature)).build().verify(jwt);
    }

}
