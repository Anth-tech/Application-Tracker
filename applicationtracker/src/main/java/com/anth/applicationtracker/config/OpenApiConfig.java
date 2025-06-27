package com.anth.applicationtracker.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI applicationTrackerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Job Application REST API")
                .description("REST API for Job Application tracking")
                .version("1.0"));
    }
}
