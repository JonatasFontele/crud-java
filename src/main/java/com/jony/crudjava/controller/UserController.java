package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/getUserByName/{name}")
    public Optional<User> getUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable Long id) throws Exception {
        return userService.findUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
