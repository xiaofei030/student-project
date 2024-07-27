package com.example.controller;

import com.example.common.BaseResponse;
import com.example.model.dto.LoginDto;
import com.example.model.dto.RegisterDto;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Project: com.example.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 21:01
 * @Description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginDto loginDto){
        return service.login(loginDto);
    }


    @PostMapping("/register")
    public BaseResponse register(@RequestBody RegisterDto registerDto){
        BaseResponse register = service.register(registerDto);
        return register;
    }
}
