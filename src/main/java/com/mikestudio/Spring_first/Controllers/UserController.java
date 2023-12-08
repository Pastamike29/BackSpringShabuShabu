package com.mikestudio.Spring_first.Controllers;

import com.mikestudio.Spring_first.Models.User;
import com.mikestudio.Spring_first.EmailService;
import com.mikestudio.Spring_first.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController  {

//    private  Map<String ,User> DB = new HashMap<>();  //for not COnnect to database
    @Autowired
    private  UserService userService;

    @Autowired
    private EmailService emailService;

    //Use for control Authenticate Login
    @PostMapping("/0/auth/user")
    public ResponseEntity<String> login(@RequestParam String username,String password){
        boolean isValidUser = userService.isValidUser(username,password);

        if (isValidUser){
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Invalid username or password",HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/0/user")
    public Iterable<User> getAllUsers(){
        return userService.get();
    }

    @GetMapping("/0/user/{UserId}")
    public User getUser(@PathVariable Integer userId){
        User user = userService.get(userId);
        if (user == null)
            throw  new ErrorResponseException(HttpStatusCode.valueOf(404));
        return user;
    }

    @PostMapping("/0/user")
    public User createUser(@RequestBody User user){
        userService.put(user);
//        userService.get(user.getUserId(),user);
//        userService.put(user.getUsername(),user);
//        userService.put(user.getPassword(),user);
//        userService.put(user.getPhonenumber(),user);
//        userService.put(user.getEmail(),user);
//        userService.put(user.getDob(),user);

        return user;

    }




    @DeleteMapping("/0/user")
    public void deleteUser(@RequestBody String userId){
         userService.remove(userId);
    }


}
