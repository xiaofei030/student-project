package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.BaseResponse;
import com.example.common.ErrorCode;
import com.example.common.ResultUtils;
import com.example.mapper.UserMapper;
import com.example.model.dto.LoginDto;
import com.example.model.dto.RegisterDto;
import com.example.model.entity.User;
import com.example.model.enums.Role;
import com.example.service.UserService;
import com.example.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: com.example.service.impl
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 18:53
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initRootUser(){
        User user = new User();
        String phone = "10000000000";

        User storeUser = userMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
        if(storeUser != null){
            userMapper.deleteById(storeUser.getId());
        }

        String password = "123123";
        long currTime = System.currentTimeMillis();
        user.setRole(Role.ADMIN.name());
        user.setPhone(phone);
        user.setPassword(passwordEncoder.encode(password));

        user.setUpdateTime(new Date(currTime));
        user.setCreateTime(new Date(currTime));

        userMapper.insert(user);
    }

    @Override
    public BaseResponse login(LoginDto loginDto) {
        String phone = loginDto.getPhone();
        User userByPhone = userMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
        if(userByPhone == null){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR,"用户不存在");
        }
        // 验证用户名和密码 验证失败时会抛异常
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            phone,
                            loginDto.getPassword()
                    )
            );
        } catch (Exception e) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "用户名或密码错误");
        }
        String token = jwtUtil.generateToken(userByPhone);
        Map<String, Object> mp = new HashMap<>();
        mp.put("token", token);
        mp.put("user", userByPhone);
        System.out.println(mp.toString());
        return ResultUtils.success(mp);
    }

    @Transactional
    @Override
    public BaseResponse register(RegisterDto registerDto) {
        String phone = registerDto.getPhone();
        User storeUser = userMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
        if(storeUser != null){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR,"手机号已注册");
        }
        String password = registerDto.getPassword();
        long currTime = System.currentTimeMillis();
        User user = new User();
        user.setRole(Role.STUDENT.name());
        user.setPhone(phone);
        user.setPassword(passwordEncoder.encode(password));
        user.setUpdateTime(new Date(currTime));
        user.setCreateTime(new Date(currTime));
        userMapper.insert(user);
        return ResultUtils.success("注册成功");
    }
}
