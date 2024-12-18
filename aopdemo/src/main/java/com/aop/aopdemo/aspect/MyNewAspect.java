package com.aop.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

        // post process data before returning to caller and format the data
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            String theUpperLevel = tempAccount.getLevel().toUpperCase();

            tempAccount.setName(theUpperName);
            tempAccount.setLevel(theUpperLevel);
        }
    }

    @AfterThrowing(pointcut = "execution(* com.aop.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        
        System.out.println(">> Executing @AfterThrowing on method: " + method);
        System.out.println(">> The exception is: " + theExc);
    }
}
