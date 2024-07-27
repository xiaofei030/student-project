package com.example.model.dto;

import lombok.Data;

/**
 * @Project: com.example.model.dto
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 19:01
 * @Description:
 */
@Data
public class UpdateStdDto {
    private String number;

    private String phone; //电话

    private String qq; //QQ

    private String address; // 家庭住址
}
