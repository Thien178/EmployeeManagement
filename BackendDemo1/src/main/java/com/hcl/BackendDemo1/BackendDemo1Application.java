package com.hcl.BackendDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.Serial;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendDemo1Application.class, args);
	}

}
