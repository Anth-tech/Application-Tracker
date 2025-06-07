package com.anth.applicationtracker;

import com.anth.applicationtracker.model.Application;
import com.anth.applicationtracker.repo.ApplicationRepository;
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
public class ApplicationtrackerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationtrackerApplication.class);
	private final ApplicationRepository applicationRepository;

	public ApplicationtrackerApplication(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationtrackerApplication.class, args);
		logger.info("ApplicationtrackerApplication started");
	}

	@Override
	public void run(String... args) throws Exception {
		Application application1 = new Application("Java Backend Developer", "Clarksville, TN",
				"LinkedIn", "TechCompany", "Pending", "In-Person",
				"Sent", new Date(System.currentTimeMillis()));
		Application application2 = new Application("Java FullStack Developer", "Nashville, TN",
				"LinkedIn", "TechieCompany", "Pending", "Remote",
				"Sent", new Date(System.currentTimeMillis()));
		applicationRepository.saveAll(Arrays.asList(application1, application2));

		for (Application application : applicationRepository.findAll()) {
			logger.info("job title: {}, location: {}, submission site: {}, company name: {}, response: {}, " +
					"job type: {}, submission status: {}, submission date: {}",
					application.getJobTitle(), application.getLocation(), application.getSubmissionSite(),
					application.getCompanyName(), application.getResponse(), application.getJobType(),
					application.getSubmissionStatus(), application.getSubmitDate());
		}
	}
}
