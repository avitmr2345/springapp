package com.aop.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.aop.aopdemo.Account;

@Aspect
@Component
public class MyNewAspect {
    @AfterReturning(pointcut = "execution(* com.aop.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturnFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println(">> Executing @AfterReturning on method: " + method);

        System.out.println("Result is: " + result);
        System.out.println();
    }
}