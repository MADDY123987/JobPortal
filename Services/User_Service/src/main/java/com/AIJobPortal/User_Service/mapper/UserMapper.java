package com.AIJobPortal.User_Service.mapper;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.job.dto.response.UserResponse;

public class UserMapper {

    public static UserResponse toDTO(User user){
        UserResponse dto=new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setPhone(user.getPhone());
        dto.setProfileImage(user.getProfileImage());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        dto.setLastLogin(user.getLastLogin());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
}
