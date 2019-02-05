package com.bank.transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.bank.transfer.controller","com.bank.transfer.service"})
public class MsTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransferApplication.class, args);
	}

}

