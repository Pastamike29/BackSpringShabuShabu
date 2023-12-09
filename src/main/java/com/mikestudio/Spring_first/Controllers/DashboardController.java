package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.Models.Dashboard;
import com.mikestudio.Spring_first.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class DashboardController {

    @Autowired
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/0/dashboard")
    public Iterable<Dashboard> getAllDashboard(){
        return  dashboardService.get();
    }

    @GetMapping("/0/dashboard/{dashboardId}")
    public Dashboard getDashboardId (@PathVariable String dashboardId){
        Dashboard dashboard =  dashboardService.get(dashboardId);
        if (dashboard == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));

        }
        return dashboard;

    }

    @PostMapping("/0/dashboard")
    public Dashboard createDashboard(@RequestBody Dashboard dashboard){
        dashboard.setCreatedAt(LocalDateTime.now());
        dashboardService.put(dashboard);
         return dashboard;
    }

    @DeleteMapping("/0/dashboard")
    public void deleteDashboard(@RequestBody String dashboardId){
        dashboardService.delete(dashboardId);
    }
}
