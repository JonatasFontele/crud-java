package com.jony.crudjava.controller;

import com.jony.crudjava.model.User;
import com.jony.crudjava.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@GetMapping
    //public List findAll(){
        //return userService.findAll();
    //}

    //@GetMapping(path = {"/{id}"})
    //public ResponseEntity findById(@PathVariable long id){
        //return repository.findById(id)
                //.map(record -> ResponseEntity.ok().body(record))
                //.orElse(ResponseEntity.notFound().build());
    //}

    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.findById(id);
    }
}
