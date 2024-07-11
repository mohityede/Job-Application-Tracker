package org.themohit.job_application_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.themohit.job_application_tracker.model.User;
import org.themohit.job_application_tracker.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username){
        return service.getUser(username);
    }

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user){
        return service.registerUser(user);
    }
}
