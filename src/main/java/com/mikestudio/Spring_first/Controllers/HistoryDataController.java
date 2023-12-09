package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.Models.HistoryData;
import com.mikestudio.Spring_first.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class HistoryDataController {

    @Autowired
    private final HistoryService historyService;

    public HistoryDataController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/0/historyData")
    public Iterable<HistoryData> getAllHistoryData(){
        return historyService.get();
    }

    @GetMapping("/0/historyData/{historyDataId}")
    public HistoryData getHistoryDataId(@PathVariable String historyDataId)  {
        HistoryData historyData = historyService.get(historyDataId);
        if (historyData == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        }
        return historyData;

    }

    @PostMapping("/0/historyData")
    public HistoryData createHistoryData(@RequestBody HistoryData historyData){
        historyData.setCreatedAt(LocalDateTime.now());
        historyService.put(historyData);

        return historyData;
    }

    @DeleteMapping("/0/historyData")
    public void deleteHistoryData(@RequestBody String historyDataId){
         historyService.delete(historyDataId);
    }

}

