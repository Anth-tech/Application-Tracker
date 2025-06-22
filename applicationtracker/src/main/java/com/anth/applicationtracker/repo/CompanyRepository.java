package com.anth.applicationtracker.repo;

import com.anth.applicationtracker.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends CrudRepository<Company, Long>, PagingAndSortingRepository<Company, Long> {
    Company findByIdAndAppUser_Username(Long id, String username);
    Page<Company> findByAppUser_Username(String username, PageRequest pageRequest);
}
