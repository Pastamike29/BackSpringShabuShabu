package com.mikestudio.Spring_first.Controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class HomeController {

    @GetMapping("/0")
    public String hello(){
        return  "Hello,World" ;
    }

    @GetMapping("/0/home")
    public String homePage(){
        return "This is homepage";
    }

//    @GetMapping("/1/admin")
//    public void adminPage(){
//    }
}
