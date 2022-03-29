package com.app.controller;

import com.app.service.LoggingService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class LoggerInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private LoggingService loggingService;
//
//    @Override
//    public boolean preHandle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object handler) throws Exception {
//
//        loggingService.logRequest(request, handler);
//
//        return true;
//    }
//}
