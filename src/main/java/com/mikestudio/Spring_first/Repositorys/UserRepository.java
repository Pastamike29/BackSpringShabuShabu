package com.mikestudio.Spring_first.Repositorys;

import com.mikestudio.Spring_first.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);


    User findByEmail(String email);
}

