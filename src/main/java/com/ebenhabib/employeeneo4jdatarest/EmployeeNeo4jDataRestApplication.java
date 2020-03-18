package com.ebenhabib.employeeneo4jdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.ebenhabib.employeeneo4jdatarest"})
public class EmployeeNeo4jDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeNeo4jDataRestApplication.class, args);
	}

}
