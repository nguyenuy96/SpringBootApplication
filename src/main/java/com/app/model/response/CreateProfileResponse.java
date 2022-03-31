package com.app.model.response;

import com.app.entity.ProfileEntity;
import lombok.Data;

@Data
public class CreateProfileResponse {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public static CreateProfileResponse convertFromProfileEntity(ProfileEntity profileEntity) {
        CreateProfileResponse responseBody = new CreateProfileResponse();
        responseBody.setAddress(profileEntity.getAddress());
        responseBody.setFirstName(profileEntity.getFirstName());
        responseBody.setLastName(profileEntity.getLastName());
        responseBody.setAddress(profileEntity.getAddress());
        responseBody.setPhoneNumber(profileEntity.getPhoneNumber());
        return responseBody;
    }
}
