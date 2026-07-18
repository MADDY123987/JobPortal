package com.AIJobPortal.User_Service.service;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.User_Service.payload.UpdateUserRequest;
import com.AIJobPortal.job.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    User getUserByEmail(String email) throws Exception;
    User getUserById(Long id) throws Exception;

    List<User> getAllUsers();

    UserResponse updatedProfile(String email, UpdateUserRequest request) throws Exception;

    //admin Action
    UserResponse suspendUser(Long id) throws Exception;

    UserResponse activateUser(Long id) throws Exception;
    UserResponse deleteUser(Long id) throws Exception;
}
