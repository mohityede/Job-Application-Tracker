package org.themohit.job_application_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class JobApplication {
    @Id
    private int jobId;
    private String jobPosition;
    private String jobDesc;
    private String company;
    private List<String> applicationStatus;

    public JobApplication(){}

    public JobApplication(int jobId, String jobPosition, String jobDesc, String company, List<String> applicationStatus) {
        this.jobId = jobId;
        this.jobPosition = jobPosition;
        this.jobDesc = jobDesc;
        this.company = company;
        this.applicationStatus = applicationStatus;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public String getCompany() {
        return company;
    }

    public List<String> getApplicationStatus() {
        return applicationStatus;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setApplicationStatus(List<String> applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "jobId=" + jobId +
                ", jobPosition='" + jobPosition + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", company='" + company + '\'' +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
