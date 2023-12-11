package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.EmailService;
import com.mikestudio.Spring_first.Services.PasswordResetService;
import com.mikestudio.Spring_first.Services.UserService;
import com.mikestudio.Spring_first.Utility;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;


@RestController
public class ResetPasswordController {
    @Autowired
    private final PasswordResetService passwordResetService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final EmailService emailService;
    public ResetPasswordController(PasswordResetService passwordResetService, UserService userService, EmailService emailService) {
        this.passwordResetService = passwordResetService;
        this.userService = userService;
        this.emailService = emailService;
    }

    //go to forgot password form
    @GetMapping("/0/forgot-password")
    public String forgotPasswordForm(){
        return "forgot_password_form";
    }

    @PostMapping("/0/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody String enteredEmail){
        String email = "" ;
        String URL = "http:localhost3000/0/forgotPassword";
        String token = Arrays.toString(SecureRandom.getSeed(30));
        String resetPasswordLink = URL + "/reset_password?token =" + token;
        userService.getEmail(email);
        try {
            if (passwordResetService.isValidEmail(enteredEmail, email)) {
                userService.updateResetPasswordToken(token,enteredEmail);
                emailService.sendResetPasswordEmail(enteredEmail, resetPasswordLink);

            } else {
                return ResponseEntity.badRequest().body("Invalid Email , Please Enter again");
            }
        }
        catch (Exception e){
            e.getMessage();
        }
        return ResponseEntity.ok("Password Reset Link successfully sent to your email please check.");
    }

}