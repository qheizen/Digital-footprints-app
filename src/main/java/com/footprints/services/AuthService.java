package com.footprints.services;

import com.footprints.dto.request.UserLoginRequest;
import com.footprints.dto.request.UserRegisterRequest;
import com.footprints.dto.response.JwtAuthResponse;
import com.footprints.entities.User;
import com.footprints.repositories.UserRepository;
import com.footprints.resources.Messages;
import com.footprints.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private static final Integer DEFAULT_ROLE_ID = 1;

    public JwtAuthResponse login(@NotNull UserLoginRequest request) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return new JwtAuthResponse(token);
    }

    public JwtAuthResponse register(@NotNull UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException(Messages.EMAIL_EXISTS);
        }
        String encodedPassword = passwordEncoder.encode(request.password());

        User user = new User();
        user.setUserEmail(request.email());
        user.setUserPassword(encodedPassword);
        user.setUsername(request.username());
        user.setRoleId(DEFAULT_ROLE_ID);
        userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return new JwtAuthResponse(token);
    }
}