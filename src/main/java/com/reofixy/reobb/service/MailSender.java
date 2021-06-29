package com.reofixy.reobb.service;

import com.reofixy.reobb.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSender {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailSender(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Mail mail) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("lewenna@gmail.com");
        helper.setTo(mail.getRecipient());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody());

        javaMailSender.send(message);
    }
}
