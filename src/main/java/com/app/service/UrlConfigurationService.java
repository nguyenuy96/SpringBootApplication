package com.app.service;

import com.app.model.BusinessException;

public interface UrlConfigurationService {
    String getRequestUrlByRequestApi(String requestApi) throws BusinessException;
}
