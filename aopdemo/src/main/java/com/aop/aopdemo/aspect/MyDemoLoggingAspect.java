package com.aop.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.aop.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.aop.aopdemo.dao.*.*(..))")
    private void forDAOPackage() {
    };

    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }

    }

    @Before("forDAOPackage()")
    public void performApiAnalytics() {
        System.out.println(">> Performing API Analytics");
    }

}
