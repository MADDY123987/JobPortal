package com.AIJobPortal.User_Service.Security;


import com.AIJobPortal.User_Service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)   {
        User user=userRepository.findByEmail(username);

        if (user==null){
            throw new UsernameNotFoundException("user not found"+username);
        }
        GrantedAuthority authority=new SimpleGrantedAuthority(user.getRole().toString());
        Collection<GrantedAuthority>grantedAuthorities= Collections.singletonList(authority);
        return new User;
    }
}
