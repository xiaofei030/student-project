package com.example.service;

import com.example.common.BaseResponse;
import com.example.model.dto.LoginDto;
import com.example.model.dto.RegisterDto;

/**
 * @Project: com.example.service
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 18:43
 * @Description:
 */
public interface UserService {
    BaseResponse login(LoginDto loginDto);

    BaseResponse register(RegisterDto registerDto);
}
