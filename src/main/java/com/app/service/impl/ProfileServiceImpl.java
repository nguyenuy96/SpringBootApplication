package com.app.service.impl;

import com.app.model.BusinessException;
import com.app.model.response.ProfileResponseModel;
import com.app.repository.ProfileRepository;
import com.app.service.BaseService;
import com.app.service.ProfileService;
import com.app.service.UrlConfigurationService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl extends BaseService implements ProfileService{
    private final ProfileRepository profileRepository;

    @Override
    public List<ProfileResponseModel> getProfiles() throws BusinessException {

        callREST("", HttpMethod.GET, ProfileResponseModel.class, null);
//        throw new BusinessException(HttpStatus.NOT_FOUND.value(), "Ahihi do ngoc");
        List<ProfileResponseModel> list = new ArrayList<>();
        ProfileResponseModel model = new ProfileResponseModel();
        list.add(model);
        return list;
    }

    @Override
    public ProfileResponseModel getProfileById(Long id) throws BusinessException {

//        template.getFor();getFor
        throw new BusinessException(HttpStatus.NOT_FOUND.value(), "Ahihi do ngoc");
    }
}
