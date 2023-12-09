package com.mikestudio.Spring_first.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.web.PortResolverImpl;

import java.time.LocalDateTime;



@Document( collection = "HISTORYDATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryData {
    @Id
    private String historyDataId;
    private String userId;
    private Integer historyTime;
    private LocalDateTime createdAt;
}
