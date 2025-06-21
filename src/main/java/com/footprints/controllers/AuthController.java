package com.footprints.controllers;

import com.footprints.dto.request.UserLoginRequest;
import com.footprints.dto.request.UserRegisterRequest;
import com.footprints.dto.response.ApiResponse;
import com.footprints.dto.response.JwtAuthResponse;
import com.footprints.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Вход в систему (логин)")
    @PostMapping("/login")
    public ApiResponse<JwtAuthResponse> login(@RequestBody UserLoginRequest request) {
        JwtAuthResponse token = authService.login(request);
        return new ApiResponse<>("success", 200, "Вход выполнен успешно", token);
    }

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping("/register")
    public ApiResponse<JwtAuthResponse> register(@RequestBody UserRegisterRequest request) {
        JwtAuthResponse token = authService.register(request);
        return new ApiResponse<>("success", 200, "Пользователь зарегистрирован", token);
    }
}