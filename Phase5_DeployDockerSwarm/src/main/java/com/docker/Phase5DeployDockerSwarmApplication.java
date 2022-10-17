package com.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Phase5DeployDockerSwarmApplication {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Setting Up Jenkins Pipeline to Deploy Docker Swarm Project..!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Phase5DeployDockerSwarmApplication.class, args);
	}

}
