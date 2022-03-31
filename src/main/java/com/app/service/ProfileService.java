package com.app.service;

import com.app.model.BusinessException;
import com.app.model.request.CreateProfileRequest;
import com.app.model.response.CreateProfileResponse;
import com.app.model.response.PaginationResponse;
import com.app.model.response.ProfileResponseListModel;
import com.app.model.response.ProfileResponseModel;
import org.springframework.data.domain.Sort;

public interface ProfileService {
    PaginationResponse<ProfileResponseModel> getProfiles(Integer page, Integer size, Sort.Direction sortType, String sortFields) throws BusinessException;
    ProfileResponseModel getProfileById(Long id) throws BusinessException;
    ProfileResponseListModel getProfilesByCallRest() throws BusinessException;
    CreateProfileResponse createProfile(CreateProfileRequest request);
}
