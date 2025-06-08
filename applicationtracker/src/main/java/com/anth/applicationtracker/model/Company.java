package com.anth.applicationtracker.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long companyid;

    @Column(nullable=false, unique=true)
    private String companyName;

    @Column(nullable=false)
    private String companyEmail;

    @Column(nullable=false)
    private String companyLocation;

    @Column(nullable=false)
    private String companyWebsite;

    public Company() {}
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
