package com.catchup.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequest {
    @NotBlank(message = "Username cannot be empty")
    private String username;

    private String bio;

    private String profilePicture;
}