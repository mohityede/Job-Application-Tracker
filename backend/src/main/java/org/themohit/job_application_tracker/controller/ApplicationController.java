package org.themohit.job_application_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.themohit.job_application_tracker.model.JobApplication;
import org.themohit.job_application_tracker.service.ApplicationService;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService service=new ApplicationService();

    @GetMapping(path = "/jobApplications",produces = {"application/json"})
    public List<JobApplication> getAllApplications(){
        return service.getAllApplications();
    }

    @GetMapping("/application/{id}")
    public JobApplication getApplication(@PathVariable("id") int id){
        return service.getApplication(id);
    }

    @PostMapping(path = "/application",consumes = {"application/json"})
    public JobApplication addApplication(@RequestBody JobApplication job){
        service.addJob(job);
        return service.getApplication(job.getJobId());
    }

    @PutMapping("/application")
    public JobApplication updateApplication(@RequestBody JobApplication job){
        service.updateApplication(job);
        return service.getApplication(job.getJobId());
    }

    @DeleteMapping("/application/{id}")
    public String deleteApplication(@PathVariable("id") int id){
        service.deleteApplication(id);
        return "deleted "+id;
    }

    @GetMapping("/application/search/{keyword}")
    public List<JobApplication> searchApplication(@PathVariable("keyword") String key){
        return service.searchJob(key);
    }
}
