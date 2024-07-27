package com.example.model.dto;

import lombok.Data;

/**
 * @Project: com.example.model.dto
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 19:02
 * @Description:
 */
@Data
public class QueryStdDto {
    private int page;
    private int pageSize;
    private String number;
    private String name;
    private String qq;
    private String phone;
}
