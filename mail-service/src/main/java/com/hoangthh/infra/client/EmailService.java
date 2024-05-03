package com.hoangthh.infra.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService  {

    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setSubject(subject);
        message.setText(content);
        message.setTo(to);
        emailSender.send(message);
    }
}
