package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Models.EmailRequest;
import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Services.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.catalina.webresources.EmptyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private OTPservice otPservice;
    @Autowired
    private UserService userService;

    //Email for authen
    @PostMapping("/0/email")
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        String genOTP = otPservice.getOTP();
        try {
            // Create the message content
            String messageContent = "This is From SINNCOSTANSHABU for Authentication your id\n" +
                    "For Authentication Please Input this number on our SignUp page.\n\n" +
                    "\t\t\t\t" + genOTP + "\n\n\n\n" +
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
            User user = new User();
            user.setOTP(genOTP);
            // Send the email
            mailSender.send(message);

            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }

    }
    @PostMapping("/0/resetPasswordEmail")
    public void sendResetPasswordEmail (String recipientEmail,String link) throws MessagingException, UnsupportedEncodingException {
        {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("sinncostanshabu@gmail.com", "SINNCOSTANSHABU Support");
            helper.setBcc(recipientEmail);

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
