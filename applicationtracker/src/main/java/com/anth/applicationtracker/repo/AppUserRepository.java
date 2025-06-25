package com.anth.applicationtracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anth.applicationtracker.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
