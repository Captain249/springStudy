package com.szj.aop.spring;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("前方法");
        Object obj = invocation.proceed();
        System.out.println("后方法");
        return obj;
    }
}
