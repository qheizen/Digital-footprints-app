package com.footprints.security;

import com.footprints.repositories.RoleRepository;
import com.footprints.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersistenceUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var user = userRepository.findByUserEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not exists by e-mail"));
        var role = roleRepository.findById(user.getRoleId()).orElseThrow(
                () -> new UsernameNotFoundException("User do not have role"));

        return new org.springframework.security.core.userdetails.User(
                user.getUserEmail(),
                user.getUserPassword(),
                Set.of(new SimpleGrantedAuthority(role.getName()))
        );
    }
}