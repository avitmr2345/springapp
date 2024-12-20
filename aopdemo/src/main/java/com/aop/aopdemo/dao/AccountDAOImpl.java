package com.aop.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("No soup for you!!");    
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("Avish", "Gold");
        Account temp2 = new Account("A", "Silver");

        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;
    }

}