package com.mikestudio.Spring_first.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.sql.Time;
import java.sql.Timestamp;

@Document(collection = "RESERVE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve_Data {
    @Id
    private String reserveDataId;
//    @DocumentReference
    private String userId;
//    @DocumentReference
    private String tableId;
    private String reserveTime;

    private String tableTypes;
    private Integer userQuantity;

}
