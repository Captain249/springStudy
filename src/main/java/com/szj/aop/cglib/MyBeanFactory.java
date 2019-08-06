package com.szj.aop.cglib;

import com.szj.aop.base.MyAspect;
import com.szj.aop.base.UserService;
import com.szj.aop.base.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {
    public static UserService createService(){
        final UserService userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                Object obj = method.invoke(userService,args);
                //methodProxy.invokeSuper(proxy, args);
                myAspect.after();
                return obj;
            }
        });
        UserServiceImpl proxService = (UserServiceImpl) enhancer.create();
        return proxService;
    }
}
