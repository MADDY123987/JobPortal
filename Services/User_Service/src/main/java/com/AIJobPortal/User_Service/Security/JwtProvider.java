package com.AIJobPortal.User_Service.Security;


import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtProvider {

    public final SecretKey secretKey=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication authentication, Long userId){
        Collection<?extends GrantedAuthority> authorities=authentication.getAuthorities();
        String role=populateAuthorities(authorities);

        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+864000000))
                .claim("email",authentication.getName())
                .claim("authorities",role)
                .claim("userId",userId)
                .signWith(secretKey)
                .compact();
    }

    public String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {

        Set<String> auths=new HashSet<>();
        for(GrantedAuthority authority:authorities){
            auths.add(authority.getAuthority());
        }
        return String.join(",",auths);
    }
}
