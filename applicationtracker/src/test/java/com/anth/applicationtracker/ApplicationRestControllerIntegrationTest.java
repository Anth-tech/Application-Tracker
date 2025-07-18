package com.anth.applicationtracker;

import com.anth.applicationtracker.repo.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationtrackerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApplicationRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationRepository applicationRepository;
}
