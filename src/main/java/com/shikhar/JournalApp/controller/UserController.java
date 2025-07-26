package com.shikhar.JournalApp.controller;

import com.shikhar.JournalApp.entity.User;
import com.shikhar.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<?> updateUserByUserName(@RequestBody User user , @PathVariable String username){
        User userInDB = userService.findByUserName(username);
        if(userInDB != null){
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
            userService.saveUser(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findbyusername/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        User users = userService.findByUserName(username);
        if(users != null && !users.equals("")){
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
