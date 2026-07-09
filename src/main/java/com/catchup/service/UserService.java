package com.catchup.service;

import com.catchup.dto.RegisterRequest;
import com.catchup.dto.LoginRequest;
public interface UserService {

    void register(RegisterRequest request);
    void login(LoginRequest request);
}