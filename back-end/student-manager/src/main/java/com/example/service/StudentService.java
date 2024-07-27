package com.example.service;

import com.example.common.BaseResponse;
import com.example.model.dto.AddStdDto;
import com.example.model.dto.DelStdDto;
import com.example.model.dto.QueryStdDto;
import com.example.model.dto.UpdateStdDto;

/**
 * @Project: com.example.service
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 19:00
 * @Description:
 */
public interface StudentService {
    // 添加学生
    BaseResponse addStudent(AddStdDto addStdDto);


    // 删除学生
    BaseResponse delStudent(DelStdDto delStdDto);

    // 改
    BaseResponse updateStudent(UpdateStdDto updateStdDto);

    BaseResponse queryStudent(QueryStdDto queryStdDto);
}
