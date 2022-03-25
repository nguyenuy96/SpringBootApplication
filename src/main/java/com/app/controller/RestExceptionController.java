package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.response.BaseResponse;
import com.app.model.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionController extends ResponseEntityExceptionHandler {
    private final ResponseUtils responseUtils;

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> handleBusinessException(BusinessException ex) {
        return responseUtils.response(ex.getMessage(), String.valueOf(ex.getErrCode()), null);
    }
}
