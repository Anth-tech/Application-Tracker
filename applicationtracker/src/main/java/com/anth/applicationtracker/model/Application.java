package com.anth.applicationtracker.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String submissionSite;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String response;

    @Column(nullable = false)
    private String jobType;

    @Column(nullable = false)
    private String submissionStatus;

    @Column(nullable = false)
    private Date submitDate;

    public Application() {
    }
    public Application(String jobTitle, String location, String submissionSite, String companyName, String response,
                       String jobType, String submissionStatus, Date submitDate) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.submissionSite = submissionSite;
        this.companyName = companyName;
        this.response = response;
        this.jobType = jobType;
        this.submissionStatus = submissionStatus;
        this.submitDate = submitDate;
    }

    public Long getId() {
        return id;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public String getLocation() {
        return location;
    }
    public String getSubmissionSite() {
        return submissionSite;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getResponse() {
        return response;
    }
    public String getJobType() {
        return jobType;
    }
    public String getSubmissionStatus() {
        return submissionStatus;
    }
    public Date getSubmitDate() {
        return submitDate;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setSubmissionSite(String submissionSite) {
        this.submissionSite = submissionSite;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
