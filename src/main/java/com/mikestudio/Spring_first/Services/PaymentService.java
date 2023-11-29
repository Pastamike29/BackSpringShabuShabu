package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.Payment;
import com.mikestudio.Spring_first.Repositorys.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Iterable<Payment> get() {
       return paymentRepository.findAll();
    }

    public Payment get(String paymentId) {
        return  paymentRepository.findById(paymentId).orElse(null);
    }



    public void remove(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }


    public void put(Payment payment) {
        paymentRepository.save(payment);
    }
}

