package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user/{id}")
    public User getUserById(@PathVariable long id) throws Exception {
        return userService.findById(id);
    }
}
