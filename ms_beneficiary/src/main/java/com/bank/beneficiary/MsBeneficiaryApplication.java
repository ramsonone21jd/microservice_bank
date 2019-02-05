package com.bank.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.bank.beneficiary.controller","com.bank.beneficiary.service"})
public class MsBeneficiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBeneficiaryApplication.class, args);
	}

}

