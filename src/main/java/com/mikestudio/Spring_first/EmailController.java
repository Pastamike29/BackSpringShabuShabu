package com.mikestudio.Spring_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    private EmailService service;

    //Sending Email
    @GetMapping("/0/email")
    public void triggerMail() {
        service.sendSimpleEmail(
                "This is From SINNCOSTANSHABU for Authentication your id",
                "For Authentication Please Input this number on our SignUp page.\n\n"+
                        "\n\t\t\t\t" + this.getRandonNum()
                        +"\n\n\n\n Warning: Don't send this email or number to other people.\t"
                        + LocalDateTime.now()
                        +"\n Use for authentication only."
                        +"\n From Sinncostanshabu.official",

                    ""
                );

    }


    //Generate number
    public String getRandonNum() {
        Random rand = new Random();
        int number = rand.nextInt(999999);
        return  String.format("%06d", number);
    }
}
