package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends MongoRepository<Table,String> {

}
