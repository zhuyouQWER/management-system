package com.zhj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wu
 * log功能，不影响核心业务
 */
@Component("logginAspectJ")
@Aspect
public class LogginAspectJ {
    /*
     */
    @Pointcut("execution(* com.zhj.controller.*.*(..))")
    public void PointcutDeclaration() {}


    @Before("PointcutDeclaration()")
    public void BeforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("BeforeMethod  The method   "+ methodName +"   parameter is  "+ Arrays.asList(args));
        System.out.println("add before");
        System.out.println();
    }


    @After("PointcutDeclaration()")
    public void AfterMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterMethod  The method    "+ methodName +"   parameter is  "+Arrays.asList(args));
        System.out.println();
    }


    @AfterReturning(value="PointcutDeclaration()",returning="result")
    public void AfterReturningMethod(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterReturningMethod  The method   "+ methodName +"   parameter is  "+Arrays.asList(args)+" "+result);
        System.out.println();
    } 


    @AfterThrowing(value="PointcutDeclaration()",throwing="e")
    public void AfterThrowingMethod(JoinPoint jp, Exception e) {
        String methodName = jp.getSignature().getName();
        System.out.println("AfterThrowingMethod  The method   "+ methodName +"exception :"+e);
    }
}
