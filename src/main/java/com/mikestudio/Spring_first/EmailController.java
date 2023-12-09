package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Models.EmailRequest;
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

    //Sending Email
//    @PostMapping ("/0/email")
//    public void triggerMail() {
//        service.sendSimpleEmail(
//                "This is From SINNCOSTANSHABU for Authentication your id",
//                "For Authentication Please Input this number on our SignUp page.\n\n"+
//                        "\n\t\t\t\t" + this.getRandonNum()
//                        +"\n\n\n\n Warning: Don't send this email or number to other people.\t"
//                        + LocalDateTime.now()
//                        +"\n Use for authentication only."
//                        +"\n From Sinncostanshabu.official",
//
//                    ""
//                );
//
//    }


    @PostMapping("/0/email")
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        try {
            // Create a SimpleMailMessage
            SimpleMailMessage message = new SimpleMailMessage();
            message.setBcc(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getBody());

            // Send the email
            mailSender.send(message);

            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }




    //Generate number
    public String getRandonNum() {
        Random rand = new Random();
        int number = rand.nextInt(999999);
        return  String.format("%06d", number);
    }
}
