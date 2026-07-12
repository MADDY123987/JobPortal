package com.AIJobPortal.User_Service.repository;

import com.AIJobPortal.User_Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);
}
