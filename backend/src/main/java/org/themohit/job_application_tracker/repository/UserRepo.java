package org.themohit.job_application_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.themohit.job_application_tracker.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByUsername(String username);
}
