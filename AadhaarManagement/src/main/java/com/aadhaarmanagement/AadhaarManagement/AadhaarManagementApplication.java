package com.aadhaarmanagement.AadhaarManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AadhaarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadhaarManagementApplication.class, args);
	}

}
