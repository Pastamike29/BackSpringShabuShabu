package com.mikestudio.Spring_first.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document(collection = "PAYMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class    Payment {
    @Id
    private String paymentId;
    private String userId;
    private String accountName;
    private Integer price;
    private String paymentDate;
    private String paymentName;
    private String statusPicture;
    private String statusPay;
    private LocalDateTime createdAt;

}
