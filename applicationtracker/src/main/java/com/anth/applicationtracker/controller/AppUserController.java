package com.anth.applicationtracker.controller;


import com.anth.applicationtracker.annotation.CurrentUser;
import com.anth.applicationtracker.model.AppUser;
import com.anth.applicationtracker.repo.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AppUserController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    public AppUserController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> findById(@PathVariable Long id, @CurrentUser String username) {
        Optional<AppUser> appUser = appUserRepository.findByIdAndUsername(id, username);
        if (appUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(appUser.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @CurrentUser String username) {
        Optional<AppUser> appUser = appUserRepository.findByIdAndUsername(id, username);
        if (appUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            appUserRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody AppUser updateAppUser, @PathVariable Long id, @CurrentUser String username) {
        Optional<AppUser> appUserExisting = appUserRepository.findByIdAndUsername(id, username);
        if (appUserExisting.isPresent() && Objects.equals(appUserExisting.get().getId(), id)) {
            appUserRepository.save(updateAppUserHelper(appUserExisting.get(), updateAppUser));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private AppUser updateAppUserHelper(AppUser prevAppUser, AppUser newAppUser) {
        prevAppUser.setFirstName(newAppUser.getFirstName());
        prevAppUser.setLastName(newAppUser.getLastName());
        prevAppUser.setUsername(newAppUser.getUsername());
        prevAppUser.setEmail(newAppUser.getEmail());
        prevAppUser.setPassword(passwordEncoder.encode(newAppUser.getPassword()));
        return prevAppUser;
    }
    
}