package com.AIJobPortal.User_Service.service.impl;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.User_Service.mapper.UserMapper;
import com.AIJobPortal.User_Service.payload.UpdateUserRequest;
import com.AIJobPortal.User_Service.repository.UserRepository;
import com.AIJobPortal.User_Service.service.UserService;
import com.AIJobPortal.job.domain.UserStatus;
import com.AIJobPortal.job.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) throws Exception {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User Not Found");
        }
        return user;
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(
                ()->new Exception("User Not Found")
        );

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse updatedProfile(String email, UpdateUserRequest request) throws Exception {
        User user=getUserByEmail(email);
        if(request.getFullName()!=null){
            user.setFullName(request.getFullName());
        }
        if(request.getPhone()!=null){
            user.setPhone(request.getPhone());
        }
        if(request.getProfileImage()!=null){
            user.setProfileImage(request.getProfileImage());
        }
        return UserMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserResponse suspendUser(Long id) throws Exception {
        User user=getUserById(id);
        user.setStatus(UserStatus.SUSPENDED);
        user.setSuspendedAt(LocalDateTime.now());
        return UserMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserResponse activateUser(Long id) throws Exception {
        User user = getUserById(id);
        user.setStatus(UserStatus.ACTIVE);
        user.setSuspendedAt(LocalDateTime.now());
        return UserMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserResponse deleteUser(Long id) throws Exception {
        User user=getUserById(id);
        user.setStatus(UserStatus.DELETED);
        user.setDeletedAt(LocalDateTime.now());
        return UserMapper.toDTO(userRepository.save(user));
    }
}
