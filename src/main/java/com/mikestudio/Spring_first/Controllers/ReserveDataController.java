package com.mikestudio.Spring_first.Controllers;

import ch.qos.logback.core.util.Loader;
import com.mikestudio.Spring_first.Models.Reserve_Data;
import com.mikestudio.Spring_first.Services.ReserveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ReserveDataController {
    @Autowired
    private ReserveDataService reserveDataService;

    @GetMapping("/0/reserveData")
    public Iterable<Reserve_Data> getAllReserveData(){
        return reserveDataService.get();

    }

    @GetMapping("/0/reserveData/{reserveDataId}")
    public Reserve_Data getReserveData(@PathVariable String reserveDataId){
        Reserve_Data reserveData = reserveDataService.get(reserveDataId);
        if (reserveData == null)
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        return reserveData;
    }

    @PostMapping("/0/reserveData")
    public Reserve_Data createReserveData(@RequestBody Reserve_Data reserveData){
        reserveData.setCreatedAt(LocalDateTime.now());
        reserveDataService.put(reserveData);

        return reserveData;
    }

    @DeleteMapping("/0/reserveData")
    public void deleteReserveData(@RequestBody String reserveDataId){
        reserveDataService.remove(reserveDataId);
    }
}
