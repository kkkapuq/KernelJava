package com.example.sisproject.global.error.exception;

import com.example.sisproject.global.error.code.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
