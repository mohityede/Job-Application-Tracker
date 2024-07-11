package org.themohit.job_application_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.themohit.job_application_tracker.model.User;
import org.themohit.job_application_tracker.model.UserPrincipal;
import org.themohit.job_application_tracker.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);
        System.out.println("suer: "+user);

        if(user ==null){
            throw new UsernameNotFoundException("User not found with username"+username);
        }
        return new UserPrincipal(user);
    }
}
