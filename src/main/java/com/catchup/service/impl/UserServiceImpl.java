package com.catchup.service.impl;

import com.catchup.dto.RegisterRequest;
import com.catchup.entity.User;
import com.catchup.exceptions.InvalidPasswordException;
import com.catchup.exceptions.UserNotFoundException;
import com.catchup.repository.UserRepository;
import com.catchup.security.JwtService;
import com.catchup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.catchup.exceptions.EmailAlreadyExistsException;
import com.catchup.dto.LoginRequest;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);
    }
    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }
}