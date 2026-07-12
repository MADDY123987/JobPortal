package com.AIJobPortal.User_Service.payload;

import com.AIJobPortal.job.dto.response.UserResponse;
import lombok.Data;

@Data
public class AuthResponse {
    private String Jwt;
    private String Title;
    private String Message;
    private UserResponse User;
}
