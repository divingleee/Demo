package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 11:04
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {

    SUCCESS(0, "操作成功"),
    UNKNOWN_ERROR(1, "未知错误"),
    ARGS_ERROR(2, "参数错误"),
    ;

    private Integer code;
    private String msg;
}
