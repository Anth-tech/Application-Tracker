package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.model.AppUser;
import com.anth.applicationtracker.model.Company;
import com.anth.applicationtracker.repo.AppUserRepository;
import com.anth.applicationtracker.repo.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final AppUserRepository appUserRepository;
    private final CompanyRepository companyRepository;
    public CompanyController(CompanyRepository companyRepository, AppUserRepository appUserRepository) {
        this.companyRepository = companyRepository;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping()
    private ResponseEntity<List<Company>> findAll(Pageable pageable, Principal principal) {
        Page<Company> page = companyRepository.findByAppUser_Username(principal.getName(),
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "companyName"))
                )
        );
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Company> findById(@PathVariable Long id, Principal principal) {
        Company company = companyRepository.findByIdAndAppUser_Username(id, principal.getName());
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    private ResponseEntity<Void> createCompany(@RequestBody Company newCompanyRequest, UriComponentsBuilder ucb, Principal principal) {
        Optional<AppUser> currentUser = appUserRepository.findByUsername(principal.getName());
        if (currentUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        newCompanyRequest.setAppUser(currentUser.get());
        Company savedCompany = companyRepository.save(newCompanyRequest);
        URI locationOfNewCompany = ucb
                .path("companies/{id}")
                .buildAndExpand(savedCompany.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewCompany).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> updateCompany(@RequestBody Company updateCompany, @PathVariable Long id, Principal principal) {
        Company existingCompany = companyRepository.findByIdAndAppUser_Username(id, principal.getName());
        if (existingCompany != null && Objects.equals(existingCompany.getId(), id)) {
            companyRepository.save(updateCompanyHelper(existingCompany, updateCompany));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteCompany(@PathVariable Long id, Principal principal) {
        Company company = companyRepository.findByIdAndAppUser_Username(id, principal.getName());
        if (company != null) {
            companyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static Company updateCompanyHelper(Company prevCompany, Company newCompany) {
        prevCompany.setCompanyName(newCompany.getCompanyName());
        prevCompany.setCompanyEmail(newCompany.getCompanyEmail());
        prevCompany.setCompanyLocation(newCompany.getCompanyLocation());
        prevCompany.setCompanyWebsite(newCompany.getCompanyWebsite());
        return prevCompany;
    }

}
