package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
    @Autowired
    private EmailService emailService;

    //for verify Email to Reset Password
    public boolean isValidEmail(String enteredEmail,String email){
        if (enteredEmail.equals(email)){
            return true;
        }
        else {
            return false;
        }
    }

}
