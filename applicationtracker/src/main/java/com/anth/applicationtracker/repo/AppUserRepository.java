package com.anth.applicationtracker.repo;

import org.springframework.data.repository.CrudRepository;
import com.anth.applicationtracker.model.AppUser;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
