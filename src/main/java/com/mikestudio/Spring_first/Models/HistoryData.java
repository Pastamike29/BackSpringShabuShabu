package com.mikestudio.Spring_first.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HISTORYDATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryData {
    private String userId;
    @Id
    private String historyDataId;
    private String reserveDataId;
    private String historyTime;
}
