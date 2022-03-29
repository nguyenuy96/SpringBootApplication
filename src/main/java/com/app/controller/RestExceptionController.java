package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.response.BaseResponse;
import com.app.model.response.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exceptions handler entries
 */
@RestControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseUtils responseUtils;

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> handleBusinessException(BusinessException ex) {
        return responseUtils.response(null, String.valueOf(ex.getErrCode()), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<?> handleException(Exception ex) {
        return responseUtils.response(null, null, ex.getMessage());
    }
}
