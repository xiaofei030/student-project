package com.example.handler;

import com.example.config.CaptchaConfig;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Project: com.example.handler
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 20:53
 * @Description:
 */
@Component
public class CaptchaCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if("/user/register".equals(request.getRequestURI())&&request.getMethod().equalsIgnoreCase("post")){
            validate(request);
        }
        filterChain.doFilter(request,response);
    }
    private void validate(HttpServletRequest request) throws IOException {

        //用户输入的验证码

        String userCode = request.getParameter("code");

        //session里的验证码对象
        String code =  (String) request.getSession().getAttribute(CaptchaConfig.CAPTCHA_SESSION_KEY);
        if(StringUtils.isEmpty(userCode)){
            throw new SessionAuthenticationException("验证码不能为空");
        }
        if(code==null){
            throw new SessionAuthenticationException("验证码不存在");
        }
        if(!code.equalsIgnoreCase(userCode)){
            throw new SessionAuthenticationException("验证码错误");
        }
    }
}
