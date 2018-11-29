package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: http 请求返回结果，分页时用到
 * @author: divingLee
 * @date: 2018/11/29 11:00
 */
@Data
@AllArgsConstructor
public class Result4Page<T> {
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回结果
     */
    private T data;
    /**
     * 所有页的总数量
     */
    private Long totalCount;

    public static <T> Result4Page<T> success(T data, Long totalCount) {
        return new Result4Page("操作成功", data, totalCount);
    }


}
