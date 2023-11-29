package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
}
