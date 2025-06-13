package com.anth.applicationtracker.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long companyid;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_website")
    private String companyWebsite;

    protected Company() {}
    public Company(String companyName, String companyEmail, String companyLocation, String companyWebsite) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyLocation = companyLocation;
        this.companyWebsite = companyWebsite;
    }

    public Long getCompanyid() {
        return companyid;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getCompanyEmail() {
        return companyEmail;
    }
    public String getCompanyLocation() {
        return companyLocation;
    }
    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }
    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }
}
