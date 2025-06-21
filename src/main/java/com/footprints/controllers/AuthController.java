package com.footprints.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.footprints.dto.request.UserLoginRequest;
import com.footprints.dto.request.UserRegisterRequest;
import com.footprints.dto.response.JwtAuthResponse;
import com.footprints.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "Вход в систему")
    @PostMapping("/login")
    public JwtAuthResponse login(@RequestBody @Valid UserLoginRequest request) {
        return authService.login(request);
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    public JwtAuthResponse register(@RequestBody @Valid UserRegisterRequest request) {
        return authService.register(request);
    }
}