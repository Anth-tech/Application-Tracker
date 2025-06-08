package com.anth.applicationtracker;

import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.model.Company;
import com.anth.applicationtracker.repo.ApplicationRepository;
import com.anth.applicationtracker.repo.CompanyRepository;
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

	public ApplicationtrackerApplication(ApplicationRepository applicationRepository, CompanyRepository companyRepository) {
		this.applicationRepository = applicationRepository;
		this.companyRepository = companyRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationtrackerApplication.class, args);
		logger.info("ApplicationtrackerApplication started");
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		Company company1 = new Company("TechCompany", "techcompany@gmail.com", "Clarksville, TN", "www.techcompany.com");
		Company company2 = new Company("TechieCompany", "techiecompany@aol.com", "Nashville, TN", "www.techiecompany.com");
		companyRepository.saveAll(Arrays.asList(company1, company2));

		Application application1 = new Application("Java Backend Developer", "Clarksville, TN",
				"LinkedIn", company1, "Pending", "In-Person",
				"Sent", new Date(System.currentTimeMillis()));
		Application application2 = new Application("Java FullStack Developer", "Nashville, TN",
				"LinkedIn", company2, "Pending", "Remote",
				"Sent", new Date(System.currentTimeMillis()));
		applicationRepository.saveAll(Arrays.asList(application1, application2));

		for (Application application : applicationRepository.findAll()) {
			logger.info("job title: {}, location: {}, submission site: {}, company name: {}, response: {}, " +
					"job type: {}, submission status: {}, submission date: {}",
					application.getJobTitle(), application.getLocation(), application.getSubmissionSite(),
					application.getCompany(), application.getResponse(), application.getJobType(),
					application.getSubmissionStatus(), application.getSubmitDate());
		}
	}
	 */
}
