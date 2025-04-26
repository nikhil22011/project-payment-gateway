package com.nike.Payment_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,String name,String course,double amount)
    {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("✅ Payment Successful - "+course);

        message.setText("Hi " + name + ",\n\n" +
                "Thank you for enrolling in " + course + ".\n\n" +
                "We look forward to seeing you in the course!\n\n" +
                "Please join telegram group link mentioned below\n\n"+
                "Best regards,\n" +
                "The [Your Team/Company Name] Team");

        mailSender.send(message);
    }
}