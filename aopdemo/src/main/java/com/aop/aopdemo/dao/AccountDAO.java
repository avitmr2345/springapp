package com.aop.aopdemo.dao;

import java.util.List;

import com.aop.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
