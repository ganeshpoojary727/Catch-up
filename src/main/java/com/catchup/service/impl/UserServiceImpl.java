package com.catchup.service.impl;

import com.catchup.dto.RegisterRequest;
import com.catchup.entity.User;
import com.catchup.repository.UserRepository;
import com.catchup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }
}