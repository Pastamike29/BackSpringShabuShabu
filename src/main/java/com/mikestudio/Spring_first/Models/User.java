package com.mikestudio.Spring_first.Models;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.function.Consumer;


@Document(collection = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    private String userId;
    private String username;
    private String password;
    private String phonenumber;
    private String email;
    private String dob;
    private String role;
    private String firstName;
    private String lastName;
    private String fullName;
    private String OTP;
    private Boolean email_verified;
    private String resetPasswordToken;

    private LocalDateTime expiryDate;
    private LocalDateTime createdAt;



}

