package com.nimish.hexagonalbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HexagonalBankingApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {

		SpringApplication.run(HexagonalBankingApplication.class, args);
		System.out.println("started");

	}
}
