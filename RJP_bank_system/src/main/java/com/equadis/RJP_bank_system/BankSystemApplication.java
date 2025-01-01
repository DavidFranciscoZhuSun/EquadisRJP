package com.equadis.RJP_bank_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApplication.class, args);
		System.out.println("System running：Initiating bank system");
	}
}
