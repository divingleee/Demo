package com.example.demo.exception;

import lombok.Data;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 14:21
 */
@Data
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
