package com.example.config;

import com.example.handler.CaptchaCodeFilter;
import com.example.handler.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Project: com.example.config
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 17:52
 * @Description:
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CaptchaCodeFilter captchaCodeFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final String[] ALLOW_URL = {"/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .rememberMe() // 开启记住我
                .and()
                .authorizeRequests()
                .antMatchers(ALLOW_URL).permitAll()
                .antMatchers("/student/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().addFilterBefore(captchaCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtAuthenticationFilter,CaptchaCodeFilter.class);
    }






}
