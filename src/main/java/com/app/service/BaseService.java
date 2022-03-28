package com.app.service;

import com.app.model.BusinessException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class BaseService {
    @Autowired
    private HttpServletRequest request;

    private static final String ACCESS_TOKEN = "token";

    /**
     * Fixme:need to correct
     * @param hostUrl
     * @param httpMethod
     * @param requestBody
     * @param responseType
     * @param uriVariables
     * @param <R>
     * @param <S>
     * @return
     * @throws BusinessException
     */
    public <R, S> S callREST(String hostUrl, HttpMethod httpMethod, R requestBody, Class<S> responseType, Map<String, ?> uriVariables) throws BusinessException {
        if (StringUtils.isEmpty(request.getHeader(ACCESS_TOKEN))) {
            throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "Access token is required");
        }

        HttpEntity<R> requestEntity = getRestTemplateHeader(httpMethod, requestBody);

        RestTemplate template = new RestTemplate();
        ResponseEntity<S> response = template.exchange(hostUrl, httpMethod, requestEntity,  responseType, uriVariables);
        return response.getBody();
    }

    private <R> HttpEntity<R> getRestTemplateHeader(HttpMethod httpMethod, R requestBody) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(request.getHeader(ACCESS_TOKEN));
        switch (httpMethod) {
            case POST : case PATCH: case PUT:
                return new HttpEntity<>(requestBody, httpHeaders);
            default:
                return new HttpEntity<>(httpHeaders);
        }
    }
}
