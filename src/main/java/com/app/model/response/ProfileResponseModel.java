package com.app.model.response;

import com.app.entity.ProfileEntity;
import com.app.model.CommonModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProfileResponseModel extends CommonModel<ProfileEntity, ProfileResponseModel> {
    private String fullName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @Override
    public ProfileResponseModel convertEntity2Model(ProfileEntity profileEntity) {
        ProfileResponseModel model = new ProfileResponseModel();
        model.setFullName(profileEntity.getFullName());
        model.setLastName(profileEntity.getLastName());
        model.setPhoneNumber(profileEntity.getPhoneNumber());
        model.setAddress(profileEntity.getAddress());
        return model;
    }
}
