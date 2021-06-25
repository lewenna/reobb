package com.reofixy.reobb.service;

import com.reofixy.reobb.core.Utils;
import com.reofixy.reobb.model.Mail;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.EmailRegistrationRequest;
import com.reofixy.reobb.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailRegistrationService implements RegistrationService<EmailRegistrationRequest> {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private MailSender mailSender;
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    public EmailRegistrationService(UserService userService, PasswordEncoder passwordEncoder, MailSender mailSender, ConfirmationTokenService confirmationTokenService){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public void register(EmailRegistrationRequest registrationRequest) {
        User user = Utils.getModelMapper().map(registrationRequest, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        userService.addUser(user);

        /*try{
            mailSender.sendMail(
                    new Mail(
                            "Confirm your email", registrationRequest.getEmail(), confirmationTokenService.createConfirmationToken(user).getToken()
                    )
            );
        }
        catch (Exception e){

        }*/
    }
}
