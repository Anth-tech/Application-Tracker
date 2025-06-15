package com.anth.applicationtracker.controller;

import com.anth.applicationtracker.exception.IdMismatchException;
import com.anth.applicationtracker.exception.NotFoundException;
import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.repo.ApplicationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping()
    private ResponseEntity<List<Application>> findAll(Pageable pageable) {
        Page<Application> page = applicationRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "submitDate"))
                )
        );
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Application> findById(@PathVariable Long id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (applicationOptional.isPresent()) {
            return ResponseEntity.ok(applicationOptional.get());
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createApplication(@RequestBody Application newApplicationRequest, UriComponentsBuilder ucb) {
        Application savedApplication = applicationRepository.save(newApplicationRequest);
        URI locationOfNewApplication = ucb
                .path("applications/{id}")
                .buildAndExpand(savedApplication.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewApplication).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        applicationRepository.findById(id).orElseThrow(NotFoundException::new);
        applicationRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@RequestBody Application application, @PathVariable Long id) {
        if (!Objects.equals(application.getId(), id)) {
            throw new IdMismatchException();
        }
        applicationRepository.findById(id).orElseThrow(NotFoundException::new);
        return applicationRepository.save(application);
    }
}
