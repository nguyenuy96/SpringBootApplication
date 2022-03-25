package com.app.service;

import com.app.model.BusinessException;
import com.app.model.response.ProfileResponseModel;
import java.util.List;

public interface ProfileService {
    List<ProfileResponseModel> getProfiles() throws BusinessException;
    ProfileResponseModel getProfileById(Long id) throws BusinessException;
}
