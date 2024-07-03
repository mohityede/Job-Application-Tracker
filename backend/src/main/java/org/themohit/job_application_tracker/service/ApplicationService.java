package org.themohit.job_application_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themohit.job_application_tracker.model.JobApplication;
import org.themohit.job_application_tracker.repository.ApplicationRepo;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo repo=new ApplicationRepo();

    public List<JobApplication> getAllApplications(){
        return repo.getAllApplications();
    }

    public void addJob(JobApplication app){
        repo.addApplication(app);
    }

    public JobApplication getApplication(int id) {
        return repo.getApplicationById(id);
    }

    public void updateApplication(JobApplication job) {
        repo.updateApplication(job);
    }

    public void deleteApplication(int id) {
        repo.deleteApplicationById(id);
    }
}
