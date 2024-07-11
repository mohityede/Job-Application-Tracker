package org.themohit.job_application_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.themohit.job_application_tracker.model.User;
import org.themohit.job_application_tracker.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public User getUser(String username){
        User user= repo.findByUsername(username);
        return user;
    }

    public User registerUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser= repo.save(user);
        return newUser;
    }
}
