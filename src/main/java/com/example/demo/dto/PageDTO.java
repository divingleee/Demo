package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 16:07
 */
@Data
public class PageDTO {
    @Min(value = 0, message = "page 不能小于 0")
    private Integer page;
    @Min(value = 1, message = "pageNum 不能小于 1")
    private Integer pageNum;
}
