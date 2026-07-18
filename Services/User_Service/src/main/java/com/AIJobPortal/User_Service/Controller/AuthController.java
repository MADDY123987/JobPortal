package com.AIJobPortal.User_Service.Controller;


import com.AIJobPortal.User_Service.payload.AuthResponse;
import com.AIJobPortal.User_Service.payload.LoginRequest;
import com.AIJobPortal.User_Service.payload.SignupRequest;
import com.AIJobPortal.User_Service.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(
            @RequestBody SignupRequest signupRequest
            ) throws Exception {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody @Valid LoginRequest request
    ) throws Exception {
        return ResponseEntity.ok(authService.login(request));
    }
}
