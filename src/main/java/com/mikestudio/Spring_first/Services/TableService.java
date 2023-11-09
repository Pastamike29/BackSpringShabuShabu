package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.Table;
import com.mikestudio.Spring_first.Repositorys.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TableService {
    private  TableRepository tableRepository;
    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Iterable<Table> get() {
        return tableRepository.findAll();
    }

    public Table get(String tableId) {
        return tableRepository.findById(tableId).orElse(null);
    }



    public void remove(String tableId) {
        tableRepository.deleteById(tableId);
    }



    public void put( Table table) {
        tableRepository.save(table);
    }


    public void remove(Table tableId) {
        tableRepository.deleteById(String.valueOf(tableId));
    }
}
