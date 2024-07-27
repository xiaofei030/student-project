package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Project: com.example.mapper
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 18:03
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
