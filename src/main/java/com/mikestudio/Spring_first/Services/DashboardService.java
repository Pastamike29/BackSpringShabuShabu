package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.Dashboard;
import com.mikestudio.Spring_first.Repositorys.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }


    public Iterable<Dashboard> get() {
        return dashboardRepository.findAll();
    }

    public Dashboard get(String dashboardId){
        return dashboardRepository.findById(dashboardId).orElse(null);
    }

    public void put(Dashboard dashboard) {
         dashboardRepository.save(dashboard);
    }

    public void delete(String dashboardId) {
        dashboardRepository.deleteById(dashboardId);
    }
}
