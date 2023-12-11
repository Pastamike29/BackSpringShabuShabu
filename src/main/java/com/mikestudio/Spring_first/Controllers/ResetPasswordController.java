package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.EmailController;
import com.mikestudio.Spring_first.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class ResetPasswordController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final EmailController emailController;
    public ResetPasswordController( UserService userService, EmailController emailController) {
        this.userService = userService;
        this.emailController = emailController;
    }

    public boolean isValidEmail(String enteredEmail,String email){
        return enteredEmail.equals(email);
    }
    @PostMapping("/0/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody String enteredEmail){

        try {
            String email = String.valueOf(userService.getEmail(enteredEmail));
            String resetPasswordLink = "http://localhost:3000/login";
            String token = UUID.randomUUID().toString();

                userService.updateResetPasswordToken(token,enteredEmail);
                emailController.sendResetPasswordEmail(enteredEmail, resetPasswordLink);

        }
        catch (Exception e){
            e.getMessage();
        }
        return ResponseEntity.ok("Password Reset Link successfully sent to your email please check.");
    }

}