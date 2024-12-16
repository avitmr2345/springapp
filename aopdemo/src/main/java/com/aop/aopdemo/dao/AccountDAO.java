package com.aop.aopdemo.dao;

import com.aop.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
}
