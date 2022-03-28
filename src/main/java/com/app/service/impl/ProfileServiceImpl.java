package com.app.service.impl;

import com.app.model.BusinessException;
import com.app.model.response.ProfileResponseListModel;
import com.app.model.response.ProfileResponseModel;
import com.app.repository.ProfileRepository;
import com.app.service.BaseService;
import com.app.service.ProfileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends BaseService implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Value("${rest.url.get.profile}")
    private String getProfileUrl;
    @Value("${rest.url.get.profiles}")
    private String getGetProfilesUrl;

    @Override
    public List<ProfileResponseModel> getProfiles() throws BusinessException {
        ProfileResponseListModel profileResponseListModel = callREST(getGetProfilesUrl, HttpMethod.GET, null, ProfileResponseListModel.class, null);
        return profileResponseListModel.getProfileResponseModels() == null ? new ArrayList<>() : profileResponseListModel.getProfileResponseModels();
    }

    @Override
    public ProfileResponseModel getProfileById(Long id) throws BusinessException {
        return callREST(getProfileUrl, HttpMethod.GET, null, ProfileResponseModel.class, null);
    }
}
