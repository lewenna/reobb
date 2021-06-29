package com.reofixy.reobb.service;

import com.reofixy.reobb.core.exception.ApiRequestException;
import com.reofixy.reobb.core.exception.ExceptionMessage;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.UserDto;
import com.reofixy.reobb.model.dto.UserUpdateRequest;
import com.reofixy.reobb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id).orElseThrow(() -> new ApiRequestException(ExceptionMessage.USER_NOT_FOUND + id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElseThrow(() -> new ApiRequestException(ExceptionMessage.USER_NOT_FOUND + username));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(() -> new ApiRequestException(ExceptionMessage.USER_NOT_FOUND + email));
    }

    @Override
    public void addUser(User user) {
        if (!isUserExists(user)){
            userRepository.save(user);
        }
        else {
            throw new ApiRequestException(ExceptionMessage.CANT_SAVABLE);
        }
    }

    @Override
    public void updateUser(String username, UserUpdateRequest userUpdateRequest) {
        userUpdateRequest.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        userRepository.updateUserById(username, userUpdateRequest);
    }

    @Override
    public boolean isUserExists(User user) {
        return userRepository.getUserById(user.getId()).isPresent() ||
                userRepository.getUserByUsername(user.getUsername()).isPresent() ||
                userRepository.getUserByEmail(user.getEmail()).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       try {
           return getUserByUsername(s);
       }
       catch (Exception e){
           return getUserByEmail(s);
       }
    }
}
