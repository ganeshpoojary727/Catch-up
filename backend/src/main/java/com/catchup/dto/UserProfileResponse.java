package com.catchup.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponse {

    private Long id;
    private String username;
    private String email;
    private String bio;
    private String profilePicture;

}