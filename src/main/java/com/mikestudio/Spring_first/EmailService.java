package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Models.User;
import com.sun.source.doctree.IndexTree;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.SimpleTimeZone;

@Service
public class EmailService{
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(
            String subject,
            String body,
            String email
    ) {


//        MimeMessage message = new MimeMessage(session);
        SimpleMailMessage message = new SimpleMailMessage();


        try {
            message.setFrom("sinncostanshabu@gmail.com");
//            message.setFrom(new InternetAddress());
            message.setText(body);
            message.setSubject(subject);
//            message.addRecipients(Message.RecipientType.BCC, String.valueOf(new InternetAddress("")));
            System.out.println(email);
            message.setBcc(email);
            message.setSentDate(new Date());


            mailSender.send(message);
            System.out.println("Sent mail success");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}



