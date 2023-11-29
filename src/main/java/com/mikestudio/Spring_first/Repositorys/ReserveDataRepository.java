package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.Reserve_Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveDataRepository extends MongoRepository<Reserve_Data,String> {

}
