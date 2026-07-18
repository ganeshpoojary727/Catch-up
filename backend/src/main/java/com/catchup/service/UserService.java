package com.catchup.service;

import com.catchup.dto.RegisterRequest;
import com.catchup.dto.LoginRequest;
import com.catchup.dto.UpdateProfileRequest;
import com.catchup.dto.UserProfileResponse;

public interface UserService {

    void register(RegisterRequest request);

    String login(LoginRequest request);

    UserProfileResponse getMyProfile();

    void updateProfile(UpdateProfileRequest request);

}