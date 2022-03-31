package com.app.model.request;

import com.app.entity.ProfileEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProfileRequest {
    @NotBlank
    @Size(min = 6, max = 50)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public static ProfileEntity convert2ProfileEntity(CreateProfileRequest request) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setAddress(request.getAddress());
        profileEntity.setFirstName(request.getFirstName());
        profileEntity.setLastName(request.getLastName());
        profileEntity.setPhoneNumber(request.getPhoneNumber());
        return profileEntity;
    }
}
