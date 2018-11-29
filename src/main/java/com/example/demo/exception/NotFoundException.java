package com.example.demo.exception;

import lombok.Data;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 14:21
 */
@Data
public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }
}
