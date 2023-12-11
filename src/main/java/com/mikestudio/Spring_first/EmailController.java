package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Models.EmailRequest;
import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Services.UserService;
import org.apache.catalina.webresources.EmptyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    private EmailService service;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private OTPservice otPservice;

    @PostMapping("/0/email")
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        try {
            // Create the message content
            String messageContent = "This is From SINNCOSTANSHABU for Authentication your id\n" +
                    "For Authentication Please Input this number on our SignUp page.\n\n" +
                    "\t\t\t\t" + otPservice.getOTP() + "\n\n\n\n" +
                    "Warning: Don't send this email or number to other people.\t" +
                    LocalDateTime.now() + "\n" +
                    "Use for authentication only.\n" +
                    "From Sinncostanshabu.official";

            // Create a SimpleMailMessage
            SimpleMailMessage message = new SimpleMailMessage();
            // Set the message details
            message.setTo(emailRequest.getTo());
            message.setSubject("Authentication Information"); // Set your subject here
            message.setText(messageContent);

            // Send the email
            mailSender.send(message);

            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }



}
