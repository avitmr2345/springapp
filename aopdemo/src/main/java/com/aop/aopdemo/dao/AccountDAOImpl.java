package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository // makes the class available for component scanning
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding an account");
    }

}
