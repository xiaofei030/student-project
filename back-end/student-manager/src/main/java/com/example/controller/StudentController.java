package com.example.controller;

import com.example.common.BaseResponse;
import com.example.model.dto.AddStdDto;
import com.example.model.dto.DelStdDto;
import com.example.model.dto.QueryStdDto;
import com.example.model.dto.UpdateStdDto;
import com.example.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @GetMapping("/query")
    public BaseResponse queryStudent(QueryStdDto queryStdDto){
        return service.queryStudent(queryStdDto);
    }

    @PostMapping("/add")
    public BaseResponse addStudent(@RequestBody AddStdDto addStdDto){
        return service.addStudent(addStdDto);
    }

    @PostMapping("/del")
    public BaseResponse delStudent(@RequestBody DelStdDto delStdDto){
        return service.delStudent(delStdDto);
    }

    @PostMapping("/update")
    public BaseResponse updateStudent(@RequestBody UpdateStdDto updateStdDto){
        return service.updateStudent(updateStdDto);
    }


}
