package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.Models.Payment;
import com.mikestudio.Spring_first.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/0/payment")
    public Iterable<Payment> getAllPayments(){
        return paymentService.get();
    }

    @GetMapping("/0/payment/{paymentId}")
    public Payment getPayment(@PathVariable String paymentId){
        Payment payment = paymentService.get(paymentId);
        if (payment == null)
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        return payment;
    }

    @PostMapping("/0/payment")
    public Payment createPayment(@RequestBody Payment payment){
        payment.setCreatedAt(LocalDateTime.now());
        paymentService.put(payment);

        return payment;
    }

    @DeleteMapping("/0/payment")
    public void deletePayment(@RequestBody String paymentId){
         paymentService.remove(paymentId);
    }
}
