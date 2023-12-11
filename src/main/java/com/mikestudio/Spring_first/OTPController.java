package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OTPController {
    @Autowired
    private final OTPservice otPservice;
    @Autowired
    private final UserService userService;

    public OTPController(OTPservice otPservice, UserService userService) {
        this.otPservice = otPservice;
        this.userService = userService;
    }
    //End point to verify-OTP
    @PostMapping("/0/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestBody String enteredOTP){
        String genOTP = otPservice.getOTP();
        if (otPservice.isValidOTP(enteredOTP,genOTP)){

            userService.save(new User(),genOTP);

            return ResponseEntity.ok("OTP Verified!!");
        }
        else {
            return ResponseEntity.badRequest().body("Invalid OTP , Please enter again");
        }
    }
}
