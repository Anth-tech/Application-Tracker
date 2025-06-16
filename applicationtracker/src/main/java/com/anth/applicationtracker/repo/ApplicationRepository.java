package com.anth.applicationtracker.repo;

import com.anth.applicationtracker.model.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApplicationRepository extends CrudRepository<Application, Long>, PagingAndSortingRepository<Application, Long> {
    Application findByIdAndAppUser_Username(Long id, String username);
    Page<Application> findByAppUser_Username(String username, PageRequest pageRequest);
}
