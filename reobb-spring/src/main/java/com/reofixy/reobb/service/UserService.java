package com.reofixy.reobb.service;

import com.reofixy.reobb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUserById(int id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(int id, User user);
    boolean isUserExists(User user);
}
