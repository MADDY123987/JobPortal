package com.AIJobPortal.User_Service.payload;

import com.AIJobPortal.job.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank(message = "Full Name is Mandatory")
    private String fullName;

    @Email(message = "Email should be Valid")
    @NotBlank(message = "Email is Mandatory")
    private String email;

    @NotBlank(message = "Password is Mandatory")
    private String password;

    private String phone;

    @NotNull(message = "Role is Mandatory")
    private UserRole role;
}
