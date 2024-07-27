package com.example.model.dto;

import lombok.Data;

/**
 * @Project: com.example.model.dto
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 19:00
 * @Description:
 */
@Data
public class AddStdDto {
    private String number; //学号

    private String name; //姓名

    private int sex; //性别 0:女 1:男

    private String phone; //电话

    private String qq; //QQ

    private String address; // 家庭住址
}
