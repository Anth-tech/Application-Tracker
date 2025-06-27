package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.annotation.CurrentUser;
import com.anth.applicationtracker.model.AppUser;
import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.repo.AppUserRepository;
import com.anth.applicationtracker.repo.ApplicationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    private final AppUserRepository appUserRepository;
    private ApplicationController(ApplicationRepository applicationRepository, AppUserRepository appUserRepository) {
        this.applicationRepository = applicationRepository;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping()
    private ResponseEntity<List<Application>> findAll(Pageable pageable, @CurrentUser String username) {
        Page<Application> page = applicationRepository.findByAppUser_Username(username,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "submitDate"))
                )
        );
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Application> findById(@PathVariable Long id, @CurrentUser String username) {
        Application application = findApplication(id, username);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createApplication(@RequestBody Application newApplicationRequest,
                                                   UriComponentsBuilder ucb, @CurrentUser String username) {
        Optional<AppUser> currentUser = appUserRepository.findByUsername(username);
        if (currentUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        newApplicationRequest.setAppUser(currentUser.get());
        Application savedApplication = applicationRepository.save(newApplicationRequest);
        URI locationOfNewApplication = ucb
                .path("applications/{id}")
                .buildAndExpand(savedApplication.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewApplication).build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteApplication(@PathVariable Long id, @CurrentUser String username) {
        Application application = findApplication(id, username);
        if (application != null) {
            applicationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> updateApplication(@RequestBody Application applicationUpdated, @PathVariable Long id,
                                                   @CurrentUser String username) {
        Application applicationExisting = findApplication(id, username);
        if (applicationExisting != null && Objects.equals(applicationExisting.getId(), id)) {
            applicationRepository.save(updateApplicationHelper(applicationExisting, applicationUpdated));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Application findApplication(Long id, String username) {
        return applicationRepository.findByIdAndAppUser_Username(id, username);
    }

    private Application updateApplicationHelper(Application prevApplication, Application newApplication) {
        prevApplication.setJobTitle(newApplication.getJobTitle());
        prevApplication.setLocation(newApplication.getLocation());
        prevApplication.setSubmissionSite(newApplication.getSubmissionSite());
        prevApplication.setCompany(newApplication.getCompany());
        prevApplication.setResponse(newApplication.getResponse());
        prevApplication.setJobType(newApplication.getJobType());
        prevApplication.setSubmissionStatus(newApplication.getSubmissionStatus());
        prevApplication.setSubmitDate(newApplication.getSubmitDate());
        return prevApplication;
    }
}
