package com.mikestudio.Spring_first;

import com.mikestudio.Spring_first.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.imageio.spi.RegisterableService;
import java.util.Random;

@Service
public class OTPservice {
    @Autowired
    private final UserService userService;

    public OTPservice(UserService userService) {
        this.userService = userService;
    }

    //Generate number
    public String getOTP() {
        Random rand = new Random();
        int number = rand.nextInt(99999);
        String genOTP = String.format("%05d", number);
        return genOTP;
    }
    //for verify OTP
    public boolean isValidOTP(String enteredOTP,String genOTP){
        if (enteredOTP.equals(genOTP)){
            return true;
        }
        else {
            return false;
        }
    }
}
