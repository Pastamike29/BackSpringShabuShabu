package com.mikestudio.Spring_first.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dashboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {
    @Id
    private String dashboardId;
    private Integer totalTableBooked;
    private Integer remainTable;
    private Integer allTodayCustomer;
    private Float todayIncome;
}
