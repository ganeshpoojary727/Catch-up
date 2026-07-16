package com.catchup.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequest {

    private String username;
    private String bio;
    private String profilePicture;

}