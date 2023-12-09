package com.mikestudio.Spring_first.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Dashboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {
    @Id
    private String dashboardId;
    private String userId;
    private String tableId;
    private String reserveDataId;
    private Integer totalTableBooked;
    private Integer remainTable;
    private Integer allTodayCustomer;
    private Float todayIncome;
    private LocalDateTime createdAt;
}
