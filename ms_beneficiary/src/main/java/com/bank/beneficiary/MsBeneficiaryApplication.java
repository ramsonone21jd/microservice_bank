package com.bank.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages= {"com.bank.beneficiary.controller","com.bank.beneficiary.service"})
@EnableDiscoveryClient
public class MsBeneficiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBeneficiaryApplication.class, args);
	}

}

