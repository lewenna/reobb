package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {
    Optional<ConfirmationToken> getConfirmationTokenByToken(String token);
}
