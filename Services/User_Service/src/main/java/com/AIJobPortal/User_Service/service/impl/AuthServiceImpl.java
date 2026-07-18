package com.AIJobPortal.User_Service.service.impl;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.User_Service.Security.CustomerUserDetailsService;
import com.AIJobPortal.User_Service.Security.JwtProvider;
import com.AIJobPortal.User_Service.mapper.UserMapper;
import com.AIJobPortal.User_Service.payload.AuthResponse;
import com.AIJobPortal.User_Service.payload.LoginRequest;
import com.AIJobPortal.User_Service.payload.SignupRequest;
import com.AIJobPortal.User_Service.repository.UserRepository;
import com.AIJobPortal.User_Service.service.AuthService;
import com.AIJobPortal.job.domain.UserRole;
import com.AIJobPortal.job.domain.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomerUserDetailsService customerUserDetailsService;

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
        Authentication authentication=new UsernamePasswordAuthenticationToken(
                user.getEmail(),user.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=jwtProvider.generateToken(authentication,savedUser.getId());

        AuthResponse authResponse=new AuthResponse();
        authResponse.setTitle("Welcome"+savedUser.getFullName());
        authResponse.setMessage("Registered Successfully");
        authResponse.setJwt(jwt);
        authResponse.setUser(UserMapper.toDTO(savedUser));


        return authResponse;
    }

    @Override
    public AuthResponse login(LoginRequest request) throws Exception {
        Authentication authentication=authenticate(
                request.getEmail(),request.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user=userRepository.findByEmail(request.getEmail());
        String jwt=jwtProvider.generateToken(authentication,user.getId());
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        AuthResponse authResponse=new AuthResponse();
        authResponse.setTitle("Welcome Back "+user.getFullName());
        authResponse.setMessage("Login Successfully");
        authResponse.setJwt(jwt);
        authResponse.setUser(UserMapper.toDTO(user));

        return authResponse;
    }

    private Authentication authenticate(@Email(message = "Email should be Valid") @NotBlank(message = "Email is Mandatory") String email, @NotBlank(message = "Password is Mandatory") String password) throws Exception {
        UserDetails userDetails=customerUserDetailsService.loadUserByUsername(email);
        if(userDetails==null){
            throw new Exception("User Not Found with Email"+email);
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new Exception("Invalid Password");
        }
        return new UsernamePasswordAuthenticationToken(
                userDetails,null,userDetails.getAuthorities());
    }
}
