package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Services.UserService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.connection.ConnectionPoolSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class EmailService{
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private  UserService userService;


    public void sendSimpleEmail(
            String subject,
            String body,
            String email
    ) {


        SimpleMailMessage message = new SimpleMailMessage();

        try {
            message.setFrom("sinncostanshabu@gmail.com");
            message.setText(body);
            message.setSubject(subject);
            message.setBcc(String.valueOf(userService.getEmail(email)));
            System.out.println("this is " + email);
            message.setSentDate(new Date());

            mailSender.send(message);
            System.out.println("Sent mail success");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}



