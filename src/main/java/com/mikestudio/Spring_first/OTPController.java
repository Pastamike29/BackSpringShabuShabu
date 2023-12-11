package com.mikestudio.Spring_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OTPController {
    @Autowired
    private final OTPservice otPservice;

    public OTPController(OTPservice otPservice) {
        this.otPservice = otPservice;
    }
    //End point to verify-OTP
    @PostMapping("/0/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestBody String enteredOTP){
        String genOTP = otPservice.getOTP();
        if (otPservice.isValidOTP(enteredOTP,genOTP)){
            return ResponseEntity.ok("OTP Verified!!");
        }
        else {
            return ResponseEntity.badRequest().body("Invalid OTP , Please enter again");
        }
    }
}
