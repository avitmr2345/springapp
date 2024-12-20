package com.spring_security.springboot.aspect;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.spring_security.springboot.controller.*.*(..))")
    private void forControllerPackage() {
    };

    @Pointcut("execution(* com.spring_security.springboot.service.*.*(..))")
    private void forServicePackage() {
    };

    @Pointcut("execution(* com.spring_security.springboot.dao.*.*(..))")
    private void forDaoPackage() {
    };

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    };

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info(">> In @Before: calling method: " + theMethod);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info(">> argument: " + tempArg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info(">> In @AfterReturning: from method: " + theMethod);

        myLogger.info(">> Result: " + theResult);
    }
}
