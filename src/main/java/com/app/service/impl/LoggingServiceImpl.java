package com.app.service.impl;

import com.app.service.LoggingService;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {

    private static final Gson gson = new Gson();
    private final Logger log = LogManager.getLogger(getClass());

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        //Fixme: add more logic for logging request
        log.info(gson.toJson(body));
    }

    @Override
    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
        //Fixme: add more logic for logging response
        log.info(gson.toJson(body));
    }
}
