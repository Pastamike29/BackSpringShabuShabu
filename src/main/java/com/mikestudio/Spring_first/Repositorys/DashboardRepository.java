package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {
}
