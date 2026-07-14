package com.AIJobPortal.User_Service.service.impl;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.User_Service.mapper.UserMapper;
import com.AIJobPortal.User_Service.payload.AuthResponse;
import com.AIJobPortal.User_Service.payload.LoginRequest;
import com.AIJobPortal.User_Service.payload.SignupRequest;
import com.AIJobPortal.User_Service.repository.UserRepository;
import com.AIJobPortal.User_Service.service.AuthService;
import com.AIJobPortal.job.domain.UserRole;
import com.AIJobPortal.job.domain.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) throws Exception {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new Exception("Email Already Registered: "+request.getEmail());
        }
        if(request.getRole()== UserRole.ROLE_ADMIN){
            throw new Exception("Cannot self-register as role admin");
        }
        User user=User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .phone(request.getPhone())
                .lastLogin(LocalDateTime.now())
                .status(UserStatus.ACTIVE)
                .build();
        User savedUser=userRepository.save(user);
        AuthResponse authResponse=new AuthResponse();
        authResponse.setTitle("Welcome"+savedUser.getFullName());
        authResponse.setMessage("Registered Successfully");
        authResponse.setJwt("jwt");
        authResponse.setUser(UserMapper.toDTO(savedUser));


        return authResponse;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
