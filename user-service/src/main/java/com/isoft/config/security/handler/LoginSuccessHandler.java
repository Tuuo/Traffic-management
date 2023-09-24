package com.isoft.config.security.handler;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.isoft.entity.User;
import com.isoft.utils.JwtUtils;
import com.isoft.utils.LoginResult;
import com.isoft.utils.ResultCode;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;

/**
 * 登录认证成功处理器类
 *
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

   @Resource
   private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //设置响应的编码格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //获取当前登录用户信息
        User user = (User) authentication.getPrincipal();
        //设置token
        String token = jwtUtils.generateToken(user);
        //设置token签名密钥及过期时间
        long expireTime = Jwts.parser() //获取DefaultJwtParser对象
                .setSigningKey(jwtUtils.getSecret())
                .parseClaimsJws(token.replace("jwt_",""))
                .getBody().getExpiration().getTime();//获取token过期时间
        //创建登录结果对象
        LoginResult loginResult = new LoginResult(user.getId(), ResultCode.SUCCESS,token,expireTime);


        //将对象转换成JSON格式，并消除循环引用
        String result = JSON.toJSONString(loginResult,
                SerializerFeature.DisableCircularReferenceDetect);
//获取输出流
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();

    }
}
