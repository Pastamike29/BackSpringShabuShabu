package com.mikestudio.Spring_first.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.sql.Timestamp;

@Document(collection = "TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @Id
    private String tableId;
    private String userId;
    private String tableStatus;
    private String reserveTime;

    private String tableType;
    private Integer userQuantity;
}
