package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;
import com.aop.aopdemo.Account;

@Repository // makes the class available for component scanning
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + ": Adding an account");
    }

}
