package com.endava.demo.controllers;


import com.endava.demo.services.IUserService;
import com.endava.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private IUserService UserService;

    public UserController(com.endava.demo.services.UserService UserService){
        this.UserService = UserService;
    }

    @GetMapping("/{UserID}")
    public User fetchOneUser(@PathVariable("UserID") long UserID){
        return this.UserService.fetchOneUser(UserID);
    }

    @GetMapping("/users")
    public List<User> fetchAllUsers(){
        return this.UserService.fetchAllUsers();
    }

    @PostMapping
    public User registerUser(@RequestBody User user){
        return this.UserService.createUser(user);
    }

    @PutMapping("/{UserID}")
    public User updateUser(@RequestBody User User, @PathVariable("UserID") long UserID){
        return this.UserService.updateUser(User, UserID);
    }

    @DeleteMapping("/{UserID}")
    public void deleteUser(@PathVariable("UserID") long UserID){
        this.UserService.deleteUser(UserID);
    }
}
