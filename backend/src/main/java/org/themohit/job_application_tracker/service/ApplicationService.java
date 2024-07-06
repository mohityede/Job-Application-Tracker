package org.themohit.job_application_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themohit.job_application_tracker.model.JobApplication;
import org.themohit.job_application_tracker.repository.ApplicationRepo;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo repo;

    public List<JobApplication> getAllApplications(){
        return repo.findAll();
    }

    public void addJob(JobApplication app){
        repo.save(app);
    }

    public JobApplication getApplication(int id) {
        return repo.findById(id).orElse(new JobApplication());
    }

    public void updateApplication(JobApplication job) {
        repo.save(job);
    }

    public void deleteApplication(int id) {
        repo.deleteById(id);
    }

    public List<JobApplication> searchJob(String key) {
        return repo.findByCompanyContainingOrJobDescContaining(key,key);
    }
}
