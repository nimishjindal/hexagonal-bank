package com.nimish.hexagonalbanking.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "com.nimish.hexagonalbanking.domain.entity")
public class HexagonalBankingApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {

		SpringApplication.run(HexagonalBankingApplication.class, args);
		System.out.println("started");

	}
}
