package com.reofixy.reobb.controller;

import com.reofixy.reobb.core.Utils;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.SecurityToken;
import com.reofixy.reobb.model.dto.UserDto;
import com.reofixy.reobb.model.dto.UserUpdateRequest;
import com.reofixy.reobb.service.SecurityTokenService;
import com.reofixy.reobb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private UserService userService;
    private SecurityTokenService securityTokenService;

    @Autowired
    public UserController(UserService userService, SecurityTokenService securityTokenService){
        this.userService = userService;
        this.securityTokenService = securityTokenService;
    }

    @PostMapping("/byId/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        User user = userService.getUserById(id);
        UserDto userDto = Utils.getModelMapper().map(user, UserDto.class);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @PostMapping("/byUsername/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        UserDto userDto = Utils.getModelMapper().map(user, UserDto.class);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserDto> updateByUsername(@RequestBody UserUpdateRequest userUpdateRequest, @RequestHeader(name="Authorization") String authorization){
        SecurityToken securityToken = new SecurityToken(authorization.replace("Bearer ", ""));
        UserDetails userDetails = securityTokenService.getUserDetailsFromToken(securityToken);
        userService.updateUser(userDetails.getUsername(), userUpdateRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/update/{username}")
    public ResponseEntity<UserDto> updateByUsername(@PathVariable String username, @RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateUser(username, userUpdateRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
