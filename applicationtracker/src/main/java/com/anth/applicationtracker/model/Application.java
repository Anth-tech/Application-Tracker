package com.anth.applicationtracker.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "location")
    private String location;

    @Column(name = "submission_site")
    private String submissionSite;

    @Column(name = "response")
    private String response;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "submission_status")
    private String submissionStatus;

    @Column(name = "submit_date")
    private Date submitDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "appuser_id", referencedColumnName = "id")
    private AppUser appUser;


    protected Application() {
    }
    private Application(Builder builder) {
        this.jobTitle = builder.jobTitle;
        this.location = builder.location;
        this.submissionSite = builder.submissionSite;
        this.company = builder.company;
        this.response = builder.response;
        this.jobType = builder.jobType;
        this.submissionStatus = builder.submissionStatus;
        this.submitDate = builder.submitDate;
        this.appUser = builder.appUser;
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
    public Company getCompany() {
        return company;
    }
    public AppUser getAppUser() {
        return appUser;
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
    public void setCompany(Company company) {
        this.company = company;
    }
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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

    public static class Builder {
        private String jobTitle;
        private String jobType;
        private String location;
        private String submissionSite;
        private Company company;
        private String response;
        private String submissionStatus;
        private Date submitDate;
        private AppUser appUser;

        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }
        public Builder jobType(String jobType) {
            this.jobType = jobType;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }
        public Builder submissionSite(String submissionSite) {
            this.submissionSite = submissionSite;
            return this;
        }
        public Builder company(Company company) {
            this.company = company;
            return this;
        }
        public Builder response(String response) {
            this.response = response;
            return this;
        }
        public Builder submissionStatus(String submissionStatus) {
            this.submissionStatus = submissionStatus;
            return this;
        }
        public Builder submitDate(Date submitDate) {
            this.submitDate = submitDate;
            return this;
        }
        public Builder appUser(AppUser appUser) {
            this.appUser = appUser;
            return this;
        }

        public Application build() {
            return new Application(this);
        }
    }
}
