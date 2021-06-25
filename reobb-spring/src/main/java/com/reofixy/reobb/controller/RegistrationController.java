package com.reofixy.reobb.controller;

import com.reofixy.reobb.model.dto.EmailRegistrationRequest;
import com.reofixy.reobb.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/api/registration")
public class RegistrationController {
    private RegistrationService<EmailRegistrationRequest> emailRegistrationService;

    public RegistrationController(RegistrationService<EmailRegistrationRequest> emailRegistrationService){
        this.emailRegistrationService = emailRegistrationService;
    }

    @PostMapping("email")
    public ResponseEntity<?> register(@RequestBody EmailRegistrationRequest emailRegistrationRequest){
        emailRegistrationService.register(emailRegistrationRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
