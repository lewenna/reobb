package com.reofixy.reobb.service;

import com.reofixy.reobb.core.exception.ApiRequestException;
import com.reofixy.reobb.core.exception.ExceptionMessage;
import com.reofixy.reobb.model.ConfirmationToken;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenServiceImpl(ConfirmationTokenRepository confirmationTokenRepository){
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public ConfirmationToken createConfirmationToken(User user) {
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setToken("token");
        confirmationToken.setExpiryDate(Date.valueOf(LocalDate.now()));
        confirmationTokenRepository.save(confirmationToken);
        return confirmationToken;
    }

    @Override
    public boolean confirmAccount(String token) {
        ConfirmationToken confirmationToken = confirmationTokenRepository.getConfirmationTokenByToken(token).orElseThrow(() -> new ApiRequestException(ExceptionMessage.NOT_FOUND + token));
        if (isConfirmationTokenValid(confirmationToken)){
            User user = confirmationToken.getUser();
            if (!user.isEnabled()){
                user.setEnabled(true);
                return true;
            }
        }
        throw new ApiRequestException(ExceptionMessage.NOT_VALID);
    }

    @Override
    public boolean isConfirmationTokenValid(ConfirmationToken confirmationToken) {
        return confirmationToken.getExpiryDate().after(Date.valueOf(LocalDate.now()));
    }
}
