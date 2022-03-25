package com.app.service;

import com.app.model.BusinessException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
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
    private UrlConfigurationService urlConfigurationService;
    @Autowired
    private HttpServletRequest request;

    private static final String ACCESS_TOKEN = "token";

    public <T> T callREST(String requestApi, HttpMethod httpMethod, Class<T> responseType, Map<String, ?> uriVariables) throws BusinessException {
        if (StringUtils.isEmpty(request.getHeader(ACCESS_TOKEN))) {
            throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "Access token is required");
        }

        String requestUrl = urlConfigurationService.getRequestUrlByRequestApi(requestApi);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(request.getHeader(ACCESS_TOKEN));
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

        RestTemplate template = new RestTemplate();
        ResponseEntity<T> response = template.exchange(requestUrl, httpMethod, requestEntity,  responseType, uriVariables);
        return response.getBody();
    }
}
