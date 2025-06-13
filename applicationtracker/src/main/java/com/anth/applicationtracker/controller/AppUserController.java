package com.anth.applicationtracker.controller;


import com.anth.applicationtracker.exception.IdMismatchException;
import com.anth.applicationtracker.model.AppUser;
import com.anth.applicationtracker.repo.AppUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import com.anth.applicationtracker.exception.NotFoundException;

import java.util.Objects;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser create(@RequestBody AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appUserRepository.findById(id).orElseThrow(NotFoundException::new);
        appUserRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public AppUser update(@RequestBody AppUser appUser, @PathVariable Long id) {
        if (!Objects.equals(appUser.getId(), id)) {
            throw new IdMismatchException();
        }
        appUserRepository.findById(id).orElseThrow(NotFoundException::new);
        return appUserRepository.save(appUser);
    }
}
