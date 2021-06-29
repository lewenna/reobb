package com.reofixy.reobb.service;

import com.reofixy.reobb.core.security.JwtUtility;
import com.reofixy.reobb.model.dto.SecurityToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtSecurityTokenService implements SecurityTokenService {
    private UserService userService;

    @Autowired
    public JwtSecurityTokenService(UserService userService){
        this.userService = userService;
    }

    @Override
    public SecurityToken createSecurityToken(UserDetails userDetails) {
        return new SecurityToken(JwtUtility.generateToken(userDetails));
    }

    @Override
    public boolean isSecurityTokenValid(SecurityToken securityToken) {
        UserDetails userDetails = userService.loadUserByUsername(JwtUtility.extractUsername(securityToken.getToken()));
        return JwtUtility.validateToken(securityToken.getToken(), userDetails);
    }

    @Override
    public UserDetails getUserDetailsFromToken(SecurityToken securityToken) {
        return userService.loadUserByUsername(JwtUtility.extractUsername(securityToken.getToken()));
    }
}
