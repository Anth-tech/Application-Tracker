package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.model.Company;
import com.anth.applicationtracker.repo.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anth.applicationtracker.exception.NotFoundException;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    // DI company repository
    private final CompanyRepository companyRepository;
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
