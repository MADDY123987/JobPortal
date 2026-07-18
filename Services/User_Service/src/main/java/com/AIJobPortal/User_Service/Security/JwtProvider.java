package com.AIJobPortal.User_Service.Security;


import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {

    private final SecretKey secretKey=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
}
