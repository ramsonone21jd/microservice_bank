package com.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //(scanBasePackages= {"com.bank.account.controller","com.bank.account.service"})
@ComponentScan(basePackages= {"com.bank.account.controller","com.bank.account.service"})
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MsAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAccountApplication.class, args);
	}

}

