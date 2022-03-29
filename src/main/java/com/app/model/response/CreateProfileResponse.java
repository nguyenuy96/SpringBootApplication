package com.app.model.response;

import lombok.Data;

@Data
public class CreateProfileResponse {
    private String fullName;
    private String address;
    private String phoneNumber;
}
