package com.reofixy.reobb.controller;

import com.reofixy.reobb.model.Post;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/byId/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }
}
