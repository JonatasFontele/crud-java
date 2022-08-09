package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    //@GetMapping(path = {"/{id}"})
    //public ResponseEntity findById(@PathVariable Long id){
        //return userService.findById(id)
                //.map(record -> ResponseEntity.ok().body(record))
                //.orElse(ResponseEntity.notFound().build());
    //}

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
