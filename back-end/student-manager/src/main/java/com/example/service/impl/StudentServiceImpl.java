package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.BaseResponse;
import com.example.common.ErrorCode;
import com.example.common.ResultUtils;
import com.example.mapper.StudentMapper;
import com.example.model.dto.AddStdDto;
import com.example.model.dto.DelStdDto;
import com.example.model.dto.QueryStdDto;
import com.example.model.dto.UpdateStdDto;
import com.example.model.entity.Student;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * @Project: com.example.service.impl
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 19:25
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    @Transactional
    @Override
    public BaseResponse addStudent(AddStdDto addStdDto) {
        Student storeStudent = studentMapper.selectOne(new QueryWrapper<Student>().eq("number", addStdDto.getNumber()));
        if(storeStudent == null){
            Student student = new Student();
            BeanUtils.copyProperties(addStdDto,student);
            long currTime = System.currentTimeMillis();
            student.setCreateTime(new Date(currTime));
            student.setUpdateTime(new Date(currTime));
            studentMapper.insert(student);
            return ResultUtils.success("插入成功");
        }else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR,"学号:" + addStdDto.getName() + " 已存在");
        }

    }

    @Transactional
    @Override
    public BaseResponse delStudent(DelStdDto delStdDto) {
        List<Long> ids = delStdDto.getIds();
        int cnt = studentMapper.deleteBatchIds(ids);
        return ResultUtils.success("成功删除" + cnt + "条记录");
    }

    @Transactional
    @Override
    public BaseResponse updateStudent(UpdateStdDto updateStdDto) {
        long currTime = System.currentTimeMillis();
        String number = updateStdDto.getNumber();
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("number", number));
        student.setQq(updateStdDto.getQq());
        student.setAddress(updateStdDto.getAddress());
        student.setPhone(updateStdDto.getPhone());
        student.setUpdateTime(new Date(currTime));
        studentMapper.updateById(student);
        return ResultUtils.success("修改成功");
    }

    @Override
    public BaseResponse queryStudent(QueryStdDto queryStdDto) {
        int page = queryStdDto.getPage();
        int pageSize = queryStdDto.getPageSize();
        Page<Student> currPage = new Page<>(page, pageSize);

        String number = queryStdDto.getNumber() == null ? "" : queryStdDto.getNumber();
        String name = queryStdDto.getName() == null ? "" : queryStdDto.getName();
        QueryWrapper<Student> wp = new QueryWrapper<>();
        wp.like("number",number);
        wp.like("name",name);

        if(!ObjectUtils.isEmpty(queryStdDto.getQq())){
            wp.eq("qq",queryStdDto.getQq());
        }
        if(!ObjectUtils.isEmpty(queryStdDto.getPhone())){
            wp.eq("phone",queryStdDto.getPhone());
        }
        System.out.println("查询参数:" + queryStdDto);
        Page<Student> studentsByPage = studentMapper.selectPage(currPage, wp);
        return ResultUtils.success(studentsByPage);
    }
}
