package com.catchup.controller;

import com.catchup.dto.UserProfileResponse;
import com.catchup.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchup.dto.UpdateProfileRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserProfileResponse getMyProfile() {
        return userService.getMyProfile();
    }
    @PutMapping("/me")
    public String updateProfile(@Valid @RequestBody UpdateProfileRequest request) {

        userService.updateProfile(request);

        return "Profile Updated Successfully";
    }

}