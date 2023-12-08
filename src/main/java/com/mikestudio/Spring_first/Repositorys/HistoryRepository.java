package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.HistoryData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends MongoRepository<HistoryData, String> {

}
