package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public  class UserService   {


    @Autowired
    private final UserRepository userRepository;

    //User for authenticate Login
    public boolean isValidUser(String username , String password){
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username,password);
        return userOptional.isPresent();
    }

    public User getEmail(String email) {
        return userRepository.findByEmail(email);

    }

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



}




