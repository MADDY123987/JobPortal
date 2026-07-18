package com.AIJobPortal.User_Service.Controller;

import com.AIJobPortal.User_Service.Model.User;
import com.AIJobPortal.User_Service.mapper.UserMapper;
import com.AIJobPortal.User_Service.payload.UpdateUserRequest;
import com.AIJobPortal.User_Service.service.UserService;
import com.AIJobPortal.job.dto.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(
            @RequestHeader("X-User-Email") String email
    ) throws Exception {
        User user=userService.getUserByEmail(email);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(
            @RequestHeader("X-User-Email") String email,
            @RequestBody @Valid UpdateUserRequest request
            ) throws Exception {
        return ResponseEntity.ok(userService.updatedProfile(email,request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable Long userId
    ) throws Exception {
        User user=userService.getUserById(userId);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(UserMapper.toDTOList(userService.getAllUsers()));
    }

    @PatchMapping("/{userId}/suspend")
    public ResponseEntity<UserResponse> suspendUser(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userService.suspendUser(userId));
    }

    @PatchMapping("/{userId}/activate")
    public ResponseEntity<UserResponse> activateUser(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userService.activateUser(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponse> deleteUser(
            @PathVariable Long userId
    ) throws Exception {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
