package com.app.controller;

import com.app.model.BusinessException;
import com.app.model.request.CreateProfileRequest;
import com.app.model.response.BaseResponse;
import com.app.model.response.CreateProfileResponse;
import com.app.model.response.PaginationResponse;
import com.app.model.response.ProfileResponseListModel;
import com.app.model.response.ProfileResponseModel;
import com.app.model.response.ResponseUtils;
import com.app.service.ProfileService;
import java.net.http.HttpHeaders;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping
    public BaseResponse<ProfileResponseModel> getProfile(@RequestHeader(required = false) HttpHeaders httpHeader,
                                                         @RequestParam("id") Long id) throws BusinessException {
        ProfileResponseModel data = profileService.getProfileById(id);
        return responseUtils.response(data, null, null);
    }

    /**
     *
     * @param page
     * @param size
     * @param sortType
     * @param sortField fields are used to sort and it must be snake case
     * @return
     * @throws BusinessException
     */
    @GetMapping("/findAll")
    public BaseResponse<PaginationResponse<ProfileResponseModel>> getAllProfiles(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortType", required = false) Sort.Direction sortType,
            @RequestParam(value = "sortField", required = false) String sortField
    ) throws BusinessException {
        PaginationResponse<ProfileResponseModel> data = profileService.getProfiles(page, size, sortType, sortField);
        return responseUtils.response(data, null, null);
    }

    @GetMapping("/call-rest")
    public BaseResponse<ProfileResponseListModel> getProfilesByCallRest() throws BusinessException {
        ProfileResponseListModel data = profileService.getProfilesByCallRest();
        return responseUtils.response(data, null, null);
    }

    @PostMapping
    public BaseResponse<CreateProfileResponse> addNewProfile(@Valid @RequestBody CreateProfileRequest request) {
        return responseUtils.response(new CreateProfileResponse(), null, null);
    }
}
