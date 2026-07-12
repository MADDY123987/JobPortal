package com.AIJobPortal.User_Service.service;

import com.AIJobPortal.User_Service.payload.AuthResponse;
import com.AIJobPortal.User_Service.payload.LoginRequest;
import com.AIJobPortal.User_Service.payload.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request) throws Exception;
    AuthResponse login(LoginRequest request);
}
