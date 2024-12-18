package com.aop.aopdemo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aop.aopdemo.dao.AccountDAO;
import com.aop.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// SpringBoot automatically inject the dependency because of @Bean annotation.
		return runner -> {
			// demoBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoAfterReturningAdvice(theAccountDAO);
			// demoAfterThrowingAdvice(theAccountDAO);
			demoAfterAdvice(theAccountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
	}

	private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("Main program: demoAfterReturningAdvice");
		System.out.println(theAccounts);
	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;

		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Main program: ...caught exception: " + exc);
		}

		System.out.println("Main program: demoAfterThrowingAdvice");
		System.out.println(theAccounts);
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;

		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Main program: ...caught exception: " + exc);
		}

		System.out.println("Main program: demoAfterAdvice");
		System.out.println(theAccounts);
	}
}
