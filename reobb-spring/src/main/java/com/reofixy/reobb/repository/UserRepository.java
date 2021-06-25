package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
    @Query("update User u set u.username = :#{#user.username}, u.avatar = :#{#user.avatar}, u.email = :#{#user.email} where u.id = ?1")
    void updateUserById(int id, @Param("user") User user);
}
