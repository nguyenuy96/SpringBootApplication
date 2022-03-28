package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.response.BaseResponse;
import com.app.model.response.ProfileResponseModel;
import com.app.model.response.ResponseUtils;
import com.app.service.ProfileService;
import com.google.gson.Gson;
import java.net.http.HttpHeaders;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ResponseUtils responseUtils;

    private final Logger log = LogManager.getLogger(getClass());
    @GetMapping
    public BaseResponse<ProfileResponseModel> getProfile(@RequestHeader(required = false) HttpHeaders httpHeader,
                                                         @RequestParam("id") Long id) throws BusinessException {
        log.info("Start get profile with id={}", id);
        ProfileResponseModel data = profileService.getProfileById(id);
        log.info("Profile result: {}", new Gson().toJson(data));
        log.info("End get profile process");
        return responseUtils.response(data, null, null);
    }

    @GetMapping("/findAll")
    public BaseResponse<List<ProfileResponseModel>> getAllProfiles() throws BusinessException {
        log.info("START::getProfiles");
        List<ProfileResponseModel> data = profileService.getProfiles();
        log.info("Profile results: {}", new Gson().toJson(data));
        log.info("END::getProfiles");

        return responseUtils.response(data, null, null);
    }
}
