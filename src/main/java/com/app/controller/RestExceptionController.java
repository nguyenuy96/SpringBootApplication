package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.response.BaseResponse;
import com.app.model.response.ResponseUtils;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
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

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse<?> handleConstraintViolationException(ConstraintViolationException ex) {
        return responseUtils.response(null, null, ex.getMessage());
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        StringBuilder errorAsString = new StringBuilder();
        errorAsString.append(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getField()).append(" ");
        errorAsString.append(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(responseUtils.response(null, null, errorAsString.toString()), HttpStatus.OK);
    }

    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,
                                                               HttpServletRequest request, HttpServletResponse response) {
        exception.printStackTrace();
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ResponseEntity<>(exception.getCause().getMessage(), HttpStatus.BAD_REQUEST);
    }
}
