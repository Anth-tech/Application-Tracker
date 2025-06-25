package com.anth.applicationtracker.repo;

import com.anth.applicationtracker.model.ERole;
import com.anth.applicationtracker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
