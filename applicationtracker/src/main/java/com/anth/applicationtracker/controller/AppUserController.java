package com.anth.applicationtracker.controller;


import com.anth.applicationtracker.model.AppUser;
import com.anth.applicationtracker.repo.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anth.applicationtracker.exception.NotFoundException;

@RestController
@RequestMapping("/api/appusers")
public class AppUserController {
    private final AppUserRepository appUserRepository;
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping
    public Iterable<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable Long id) {
        return appUserRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
