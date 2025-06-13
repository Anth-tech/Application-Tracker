package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.exception.IdMismatchException;
import com.anth.applicationtracker.model.Company;
import com.anth.applicationtracker.repo.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.anth.applicationtracker.exception.NotFoundException;

import java.util.Objects;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        companyRepository.findById(id).orElseThrow(NotFoundException::new);
        companyRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Company update(@RequestBody Company company, @PathVariable Long id) {
        if (!Objects.equals(company.getId(), id)) {
            throw new IdMismatchException();
        }
        companyRepository.findById(id).orElseThrow(NotFoundException::new);
        return companyRepository.save(company);
    }
}
