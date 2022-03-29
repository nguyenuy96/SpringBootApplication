package com.app.model.response;

import com.app.utils.MyStringUtils;
import org.springframework.stereotype.Component;

/**
 * Entry for api response
 */
@Component
public class ResponseUtils {

    /**
     * Common response for api calling
     * @param data pass data as parameter for successful response
     * @param messageCode depend on success or failure
     * @param message message for response (successful message or exception/failure message)
     * @param <T> data/content of response
     * @return Common response for all api
     */
    public <T> BaseResponse<T> response(T data, String messageCode, String message) {
        return new BaseResponse<>(MyStringUtils.getValue(messageCode), MyStringUtils.getValue(message), data);
    }

    //Write more response for success or failure if any
}
