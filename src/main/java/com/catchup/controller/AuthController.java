package com.catchup.controller;

import com.catchup.dto.LoginRequest;
import com.catchup.dto.RegisterRequest;
import com.catchup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {

        userService.register(request);

        return "User Registered Successfully";
    }
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {

        userService.login(request);

        return "Login Successful";
    }
}