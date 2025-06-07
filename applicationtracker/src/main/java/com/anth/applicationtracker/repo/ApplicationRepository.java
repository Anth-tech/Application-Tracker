package com.anth.applicationtracker.repo;

import com.anth.applicationtracker.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
