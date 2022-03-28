package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.response.BaseResponse;
import com.app.model.response.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseUtils responseUtils;

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> handleBusinessException(BusinessException ex) {
        return responseUtils.response(ex.getMessage(), String.valueOf(ex.getErrCode()), null);
    }
}
