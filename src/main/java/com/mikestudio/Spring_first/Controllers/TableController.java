package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.Models.Table;
import com.mikestudio.Spring_first.Services.TableService;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TableController {
    private Map<String,Table> DB = new HashMap<>();

    @Autowired
    private TableService tableService;



    @GetMapping("/0/table")
    public Iterable<Table> getAllTables(){
        return  tableService.get();
    }

    @GetMapping("/0/table/{tableId}")
    public Table getTable(@PathVariable String tableId){
        Table table = tableService.get(tableId);
        if (table == null)
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        return table;
    }

    @PostMapping("/0/table")
    public Table createTable(@RequestBody Table table){
        table.setCreatedAt(LocalDateTime.now());
        tableService.put(table);

        return table;
    }

    @DeleteMapping("/0/table")
    public void deleteTable(@RequestBody Table tableId){
         tableService.remove(tableId);
    }


}
