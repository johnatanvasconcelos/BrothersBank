package com.meuprojeto.brothersbank;

import com.meuprojeto.brothersbank.config.StartupRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.meuprojeto.brothersbank")
public class BrothersbankApplication{

	public static void main(String[] args) {
		SpringApplication.run(BrothersbankApplication.class, args);
	}
}
