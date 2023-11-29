package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public  class UserService   {



    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Iterable<User> get() {
        return userRepository.findAll();
    }

    public User get(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public void put( User user) {
        userRepository.save(user);
    }


    public void remove(String userId) {
        userRepository.deleteById(Integer.valueOf(userId));
    }


    public List<User> getEmail(User email) {
        return userRepository.findAll();

    }
}




