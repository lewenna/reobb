package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.UserDto;
import com.reofixy.reobb.model.dto.UserUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
    @Query("update User u set u.username = :#{#userUpdateRequest.username}, u.avatar = :#{#userUpdateRequest.avatar}, u.email = :#{#userUpdateRequest.email}, u.password = :#{#userUpdateRequest.password} where u.username = ?1")
    void updateUserById(String username, @Param("userUpdateRequest") UserUpdateRequest userUpdateRequest);
}
