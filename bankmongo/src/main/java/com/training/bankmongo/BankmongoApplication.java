package com.training.bankmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankmongoApplication.class, args);
	}
}
