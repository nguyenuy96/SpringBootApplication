package com.app.service;

import com.app.model.BusinessException;
import com.app.model.CommonModel;
import com.app.model.response.PaginationResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //Fixme: if call ssl, refer to https://www.baeldung.com/httpclient-ssl#resttemplate_ssl-1
    @Autowired
    private RestTemplate template;

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

        ResponseEntity<S> response = template.exchange(hostUrl, httpMethod, requestEntity,  responseType, uriVariables);
        return response.getBody();
    }

    public Pageable getPageable(Integer page, Integer size, Sort.Direction sortType, String sortFields) {
        if (sortType != null) {
            if (sortFields != null) {
                //Need to trim to remove space and use camelCase to meet attribute(s) of entity
                String[] properties = Arrays.stream(sortFields.split(","))
                        .map(s -> CaseUtils.toCamelCase(s.trim(), false, '_')).toArray(String[]::new);
                if (properties.length > 0) {
                    return PageRequest.of(page, size, sortType, properties);
                }
            } else {
                return PageRequest.of(page, size, sortType);
            }
        }
        return PageRequest.of(page, size);
    }

    public <E, M> PaginationResponse<M> getPaginationResponse(Page<E> page, CommonModel<E, M> commonModel) {
        PaginationResponse<M> paginationResponse = new PaginationResponse<>();
        paginationResponse.setPage(page.getNumber());
        paginationResponse.setSize(page.getSize());
        paginationResponse.setTotal(page.getTotalElements());
        List<E> pageResult = page.getContent();
        paginationResponse.setContent(pageResult.stream().map(commonModel::convertEntity2Model).collect(Collectors.toList()));
        return paginationResponse;
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
