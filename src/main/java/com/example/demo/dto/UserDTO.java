package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 10:25
 */
@Data
@AllArgsConstructor
public class UserDTO {
    @NotEmpty(message = "名称不能为空")
    private String name;
    @NotEmpty(message = "年龄不能为空")
    private Integer age;
    private String company;
}
