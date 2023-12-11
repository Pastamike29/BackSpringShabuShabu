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

    public boolean isValidEmail(String enteredEmail,String exitedEmail){
        if (enteredEmail.equals(exitedEmail)){
            return true;
        }
        else {
            return false;
        }
    }
    @PostMapping("/0/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody String enteredEmail){
        String email = "";
        email = String.valueOf(userService.getEmail(email));
        String resetPasswordLink = "http://localhost:3000/0/forgotPassword";
        String token = UUID.randomUUID().toString();

        try {
            if ( isValidEmail(enteredEmail, email)) {
                userService.updateResetPasswordToken(token,enteredEmail);
                emailController.sendResetPasswordEmail(enteredEmail, resetPasswordLink);

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