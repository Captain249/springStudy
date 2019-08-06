package com.szj.aop.zhujie;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.szj.aop.zhujie.StudentService.*(..))")
    public void myPointCut(){
    }

    @Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("前");
        //手动执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("后");
        return obj;
    }
}
