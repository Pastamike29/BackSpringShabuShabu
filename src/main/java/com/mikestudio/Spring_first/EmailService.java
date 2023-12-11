package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Services.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class EmailService{
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private  UserService userService;

    //Email for Authentication register
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
            message.setSentDate(new Date());

            mailSender.send(message);
            System.out.println("Sent mail success");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //Email for reset password
    public void sendResetPasswordEmail (String recipientEmail,String link) throws MessagingException, UnsupportedEncodingException {
           {
                link = "http:localhost3000/0/forgotPassword";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("sinncostanshabu@gmail.com", "SINNCOSTANSHABU Support");
            helper.setTo(recipientEmail);

            String subject = "Here's the link to reset your password";

            String content = "<p>Hello,</p>"
                    + "<p>You have requested to reset your password.</p>"
                    + "<p>Click the link below to change your password:</p>"
                    + "<p><a href=\"" + link + "\">Change my password</a></p>"
                    + "<br>"
                    + "<p>Ignore this email if you do remember your password, "
                    + "or you have not made the request.</p>";

            helper.setSubject(subject);

            helper.setText(content, true);

            mailSender.send(message);
        }
    }

}



