package com.app.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProfileRequest {
    @NotBlank
    @Size(min = 6, max = 50)
    private String fullName;
    private String phoneNumber;
    private String address;
}
