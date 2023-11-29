package com.mikestudio.Spring_first.Controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class HomeController {

    @CrossOrigin(origins = "http://localhost:2929")
    @GetMapping("/0")
    public String hello(){
        return  "Hello,World" ;
    }

    @CrossOrigin(origins = "http://localhost:2929")
    @GetMapping("/0/home")
    public String homePage(){
        return "This is homepage";
    }

    @CrossOrigin(origins = "http://localhost:2929")
    @GetMapping("/1/admin")
    public void adminPage(){
    }
}
