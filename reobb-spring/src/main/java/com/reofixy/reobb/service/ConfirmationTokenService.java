package com.reofixy.reobb.service;

import com.reofixy.reobb.model.ConfirmationToken;
import com.reofixy.reobb.model.User;

public interface ConfirmationTokenService {
    ConfirmationToken createConfirmationToken(User user);
    boolean confirmAccount(String token);
    boolean isConfirmationTokenValid(ConfirmationToken confirmationToken);
}
