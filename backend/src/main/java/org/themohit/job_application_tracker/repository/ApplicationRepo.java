package org.themohit.job_application_tracker.repository;

import org.springframework.stereotype.Repository;
import org.themohit.job_application_tracker.model.JobApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ApplicationRepo {
    private List<JobApplication> jobs=new ArrayList<>(Arrays.asList(
            new JobApplication(1,"Full Stack Dev","Good Job","Google",new ArrayList<String>(Arrays.asList("Applied","Rejected"))),
            new JobApplication(2,"React Dev","Good Job","Microsoft",new ArrayList<String>(Arrays.asList("Applied","Rejected"))),
            new JobApplication(3,"Java Dev","Good Job","Amazon",new ArrayList<String>(Arrays.asList("Applied","Rejected")))
    ));

    public List<JobApplication> getAllApplications(){
        return jobs;
    }

    public void addApplication(JobApplication jobApp){
        jobs.add(jobApp);
    }

    public JobApplication getApplicationById(int id) {
        for(JobApplication job:jobs){
            if(job.getJobId() == id) return job;
        }
        return null;
    }

    public void updateApplication(JobApplication job) {
        for(JobApplication app:jobs){
            if(app.getJobId() == job.getJobId()){
                app.setApplicationStatus(job.getApplicationStatus());
                app.setCompany(job.getCompany());
                app.setJobDesc(job.getJobDesc());
                app.setJobPosition(job.getJobPosition());
                break;
            }
        }
    }

    public void deleteApplicationById(int id) {
        jobs= jobs.stream().filter((jobApplication -> jobApplication.getJobId() != id)).toList();
    }
}
