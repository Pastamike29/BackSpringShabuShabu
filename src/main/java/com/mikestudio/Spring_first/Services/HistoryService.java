package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.HistoryData;
import com.mikestudio.Spring_first.Repositorys.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterIOException;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public Iterable<HistoryData> get() {
     return  historyRepository.findAll();
    }

    public HistoryData get(String historyDataId){

        return historyRepository.findById(historyDataId).orElse(null);
    }


    public void put(HistoryData historyData) {
         historyRepository.save(historyData);
    }

    public void delete(String historyDataId) {
        historyRepository.deleteById(historyDataId);
    }
}
