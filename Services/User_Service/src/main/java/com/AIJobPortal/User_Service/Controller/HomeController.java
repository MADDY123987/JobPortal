package com.AIJobPortal.User_Service.Controller;


import com.AIJobPortal.job.domain.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String HomeController(){
        return "Job Portal User Service"+ UserRole.ROLE_JOB_SEEKER;
    }
}
