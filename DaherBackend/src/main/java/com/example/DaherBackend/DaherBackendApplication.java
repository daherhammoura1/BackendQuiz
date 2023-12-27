package com.example.DaherBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.DaherBackend.Repository")
@ComponentScan({"com.example.DaherBackend", "com.example.DaherBackend.Controller", "com.example.DaherBackend.Repository"})
@SpringBootApplication
public class DaherBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(DaherBackendApplication.class, args);
	}
}
