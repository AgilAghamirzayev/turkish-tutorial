package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.example.aop.service.MessageService.getMessage(..))")
    public void beforeGetMessage(JoinPoint joinPoint){
        System.out.println("Before getMessage() method executed: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.example.aop.service.*.*(..))")
    public void afterGetMessage(JoinPoint joinPoint){
        System.out.println("After getMessage() method executed: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
