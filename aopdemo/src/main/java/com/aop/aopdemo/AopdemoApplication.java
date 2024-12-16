package com.aop.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aop.aopdemo.dao.AccountDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) { // SpringBoot automatically inject the
																			// dependency because of @Bean annotation.
		return runner -> {
			demoBeforeAdvice(theAccountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO) {
		theAccountDAO.addAccount();
	}

}
