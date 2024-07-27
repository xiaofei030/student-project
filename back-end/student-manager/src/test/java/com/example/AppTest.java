package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.StudentMapper;
import com.example.mapper.UserMapper;
import com.example.model.dto.AddStdDto;
import com.example.model.dto.QueryStdDto;
import com.example.model.entity.Student;
import com.example.model.entity.User;
import com.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Project: com.example
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 18:06
 * @Description:
 */
@SpringBootTest
public class AppTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentService service;

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void test(){
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        System.out.println(users);
    }

    @Test
    public void addStudent() {
        AddStdDto addStdDto = new AddStdDto();
        addStdDto.setQq("2043393364");
        addStdDto.setName("张三");
        addStdDto.setSex(1);
        addStdDto.setPhone("10086");
        addStdDto.setAddress("安徽合肥");
        addStdDto.setNumber("2021215849");
        service.addStudent(addStdDto);
    }

    @Test
    public void addMoreTest() {
        for (int i = 1; i <= 20; i++) {
            AddStdDto addStdDto = new AddStdDto();
            addStdDto.setQq("1000000000" + i);
            addStdDto.setName("学生" + i);
            addStdDto.setSex(i % 2);
            addStdDto.setPhone("1888888888" + i);
            addStdDto.setAddress("测试地址" + i);
            addStdDto.setNumber("2021215800" + i);
            service.addStudent(addStdDto);
        }
    }

    @Test
    public void queryTest(){
        QueryStdDto queryStdDto = new QueryStdDto();
        Page<Student> page = new Page<>(0, 10);
        QueryWrapper<Student> wp = new QueryWrapper<>();
        wp.like("number", "");
        wp.like("name","");

        Page<Student> result = studentMapper.selectPage(page, wp);
        System.out.println(result.getRecords());
    }
}
