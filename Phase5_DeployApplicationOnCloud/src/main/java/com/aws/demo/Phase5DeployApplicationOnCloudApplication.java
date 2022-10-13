package com.aws.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Phase5DeployApplicationOnCloudApplication {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Deploy an Application on AWS Cloud Project...!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Phase5DeployApplicationOnCloudApplication.class, args);
	}

}
