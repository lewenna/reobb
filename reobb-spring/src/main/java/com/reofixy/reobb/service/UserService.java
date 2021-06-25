package com.reofixy.reobb.service;

import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.UserDto;
import com.reofixy.reobb.model.dto.UserUpdateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUserById(int id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(String username, UserUpdateRequest userUpdateRequest);
    boolean isUserExists(User user);
}
