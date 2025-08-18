package com.diptech.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactNotification(String name, String email, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("your-email@example.com"); // Your email
        mail.setSubject("📩 New Contact from Portfolio Website");
        mail.setText(
                "You have a new contact:\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Message: " + message
        );

        mailSender.send(mail);
        System.out.println("✅ Contact notification sent to email");
    }
}
