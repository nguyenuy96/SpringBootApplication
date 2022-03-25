package com.app.model.response;

import com.app.utils.MyStringUtils;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {
    public <T> BaseResponse<T> response(T data, String messageCode, String message) {
        return new BaseResponse<>(MyStringUtils.getValue(messageCode), MyStringUtils.getValue(message), data);
    }
}
