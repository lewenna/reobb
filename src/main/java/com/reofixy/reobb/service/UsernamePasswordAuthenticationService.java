package com.reofixy.reobb.service;

import com.reofixy.reobb.core.exception.ApiRequestException;
import com.reofixy.reobb.core.exception.ExceptionMessage;
import com.reofixy.reobb.model.dto.SecurityToken;
import com.reofixy.reobb.model.dto.UsernamePasswordAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsernamePasswordAuthenticationService implements AuthenticationService<UsernamePasswordAuthenticationRequest> {
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private SecurityTokenService securityTokenService;

    @Autowired
    public UsernamePasswordAuthenticationService(UserService userService, AuthenticationManager authenticationManager, SecurityTokenService securityTokenService){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.securityTokenService = securityTokenService;
    }
    @Override
    public SecurityToken authenticate(UsernamePasswordAuthenticationRequest authenticationRequest) {
        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            ));
        }
        catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
        return securityTokenService.createSecurityToken(userDetails);
    }
}
