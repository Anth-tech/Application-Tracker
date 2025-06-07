package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.exception.ApplicationNotFoundException;
import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.repo.ApplicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping
    public Iterable<Application> findAll() {
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Application findOne(@PathVariable Long id) {
        return applicationRepository.findById(id).orElseThrow(ApplicationNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application create(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        applicationRepository.findById(id).orElseThrow(ApplicationNotFoundException::new);
        applicationRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@RequestBody Application application, @PathVariable Long id) {
        if (!Objects.equals(application.getId(), id)) {
            throw new ApplicationIdMismatchException();
        }
        applicationRepository.findById(id).orElseThrow(ApplcationNotFoundException::new);
        return applicationRepository.save(application);
    }
}
