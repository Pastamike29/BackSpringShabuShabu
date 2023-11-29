package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.Reserve_Data;
import com.mikestudio.Spring_first.Repositorys.ReserveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveDataService {
    @Autowired
    private ReserveDataRepository reserveDataRepository;

    public ReserveDataService(ReserveDataRepository reserveDataRepository) {
        this.reserveDataRepository = reserveDataRepository;
    }


    public Iterable<Reserve_Data> get() {
        return  reserveDataRepository.findAll();
    }

    public Reserve_Data get(String reserveDataId) {
        return  reserveDataRepository.findById(reserveDataId).orElse(null);
    }

    public void put(Reserve_Data reserveData) {
        reserveDataRepository.save(reserveData);
    }

    public void remove(String reserveDataId) {
        reserveDataRepository.deleteById(reserveDataId);
    }
}
