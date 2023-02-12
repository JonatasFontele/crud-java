package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Iterable<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/getUserByName/{name}")
    public Iterable<User> getUserByName(@PathVariable String name) {
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

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.findUserById(id)
                .map(record -> {
                    record.setName(user.getName());
                    User updated = userService.createUser(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(record -> {
                    userService.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
