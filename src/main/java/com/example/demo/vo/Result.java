package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: http 请求返回结果
 * @author: divingLee
 * @date: 2018/11/29 11:00
 */
@Data
@AllArgsConstructor
public class Result<T> {
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回结果
     */
    private T data;

    public static <T> Result<T> success() {
        return new Result("操作成功", null);
    }

    public static <T> Result<T> successWithData(T data) {
        return new Result("操作成功", data);
    }

    public static <T> Result<T> failWithMsg(String msg) {
        return new Result(msg, null);
    }

    public static <T> Result<T> successWithDataAndPage(T data) {
        return new Result("操作成功", data);
    }

}
