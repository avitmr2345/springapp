package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding a member account");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now");
    }

}
