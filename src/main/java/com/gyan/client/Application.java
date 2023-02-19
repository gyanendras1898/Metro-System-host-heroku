package com.gyan.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.gyan")
@EnableJpaRepositories(basePackages = "com.gyan.model.persistence")
@EntityScan(basePackages = "com.gyan.beans")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
