package com.catchup.controller;

import com.catchup.dto.RegisterRequest;
import com.catchup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        userService.register(request);

        return "User Registered Successfully";
    }
}