package com.cognizant.normal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NormalUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NormalUserServiceApplication.class, args);
	}

}
