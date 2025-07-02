package com.anth.applicationtracker;

import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.model.Company;
import com.anth.applicationtracker.repo.AppUserRepository;
import com.anth.applicationtracker.repo.ApplicationRepository;
import com.anth.applicationtracker.repo.CompanyRepository;
import com.anth.applicationtracker.repo.RoleRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.Arrays;

@EnableJpaRepositories("com.anth.applicationtracker.repo")
@EntityScan("com.anth.applicationtracker.model")
@SpringBootApplication
public class ApplicationtrackerApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationtrackerApplication.class);
	private final ApplicationRepository applicationRepository;
	private final CompanyRepository companyRepository;
	private final AppUserRepository appUserRepository;
	private final RoleRepository roleRepository;

	public ApplicationtrackerApplication(ApplicationRepository applicationRepository,
										 CompanyRepository companyRepository, AppUserRepository appUserRepository,
										 RoleRepository roleRepository) {
		this.applicationRepository = applicationRepository;
		this.companyRepository = companyRepository;
		this.appUserRepository = appUserRepository;
		this.roleRepository = roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationtrackerApplication.class, args);
		logger.info("ApplicationtrackerApplication started");
	}

}
