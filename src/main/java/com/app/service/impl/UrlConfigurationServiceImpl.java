package com.app.service.impl;

import com.app.entity.UrlConfigurationEntity;
import com.app.model.BusinessException;
import com.app.repository.UrlConfigurationRepository;
import com.app.service.UrlConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UrlConfigurationServiceImpl implements UrlConfigurationService {

    private final UrlConfigurationRepository urlConfigurationRepository;

    @Override
    public String getRequestUrlByRequestApi(String requestApi) throws BusinessException {
        UrlConfigurationEntity urlConfigurationEntity = urlConfigurationRepository.findByRequestApi(requestApi)
                .orElseThrow(() -> new BusinessException(
                        HttpStatus.NOT_FOUND.value(),
                        String.format("Not found configuration with api name [%s]", requestApi))
                );
        if (StringUtils.isEmpty(urlConfigurationEntity.getRequestUrl())) {
            throw new BusinessException(HttpStatus.NOT_FOUND.value(), "request url configuration is null or empty");
        }

        return urlConfigurationEntity.getRequestUrl();
    }
}
