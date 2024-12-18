package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;
import com.aop.aopdemo.Account;

@Repository // makes the class available for component scanning
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Adding an account");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("Avish", "Tomar");
        Account temp2 = new Account("A", "T");

        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;
    }

}
