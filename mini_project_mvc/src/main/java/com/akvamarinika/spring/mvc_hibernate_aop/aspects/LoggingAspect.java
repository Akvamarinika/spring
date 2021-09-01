package com.akvamarinika.spring.mvc_hibernate_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.akvamarinika.spring.mvc_hibernate_aop.dao.Employee*.*(..))")
    public Object aroundAllRepositoryEmployeeMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();
        System.out.println("Begin method: " + nameMethod);
        long timeStart = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
        long timeEnd = System.currentTimeMillis();
        System.out.println("End method: "  + nameMethod);
        System.out.println("Time ms: " + (timeEnd-timeStart));
        return targetMethodResult;
    }
}
