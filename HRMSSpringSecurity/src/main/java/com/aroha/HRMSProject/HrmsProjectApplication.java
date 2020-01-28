package com.aroha.HRMSProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.aroha.HRMSProject.model.Candidate;

@SpringBootApplication
@EnableConfigurationProperties({
        Candidate.class
})
public class HrmsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsProjectApplication.class, args);
	}

}
