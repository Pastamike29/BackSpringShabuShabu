package com.mikestudio.Spring_first.Services;

import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.time.LocalDateTime;
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
    //For get Email from database
    public User getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void updateResetPasswordToken(String token,String email){
        User user = userRepository.findByEmail(email);
        if (user != null){

            user.setResetPasswordToken(token);

            userRepository.save(user);
        }else {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    public User getByResetPasswordToken(String token){
        return userRepository.findByResetPasswordToken(token);
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

    //for saveRandomNumber(OTP)
    public void save(String OTP) {
        User user = new User();
        user.getUserId();
        user.getUsername();
        user.getPassword();
        user.getPhonenumber();
        user.getDob();
        user.getEmail();
        user.getRole();
        user.getFirstName();
        user.getLastName();
        user.getFullName();
        user.getEmail_verified();
        user.setOTP(OTP);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    public User updateUser(User existedUser) {
        return userRepository.save(existedUser);
    }
}




