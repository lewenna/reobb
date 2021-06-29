package com.reofixy.reobb.controller;

import com.reofixy.reobb.model.dto.UsernamePasswordAuthenticationRequest;
import com.reofixy.reobb.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/api/authentication")
public class AuthenticationController {
    private AuthenticationService<UsernamePasswordAuthenticationRequest> usernamePasswordAuthenticationService;

    public AuthenticationController(AuthenticationService<UsernamePasswordAuthenticationRequest> usernamePasswordAuthenticationService){
        this.usernamePasswordAuthenticationService = usernamePasswordAuthenticationService;
    }

    @PostMapping("usernamepassword")
    public ResponseEntity<?> login(@RequestBody UsernamePasswordAuthenticationRequest usernamePasswordAuthenticationRequest){
        return new ResponseEntity(usernamePasswordAuthenticationService.authenticate(usernamePasswordAuthenticationRequest), HttpStatus.OK);
    }
}