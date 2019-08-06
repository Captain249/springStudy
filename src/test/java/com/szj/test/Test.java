package com.szj.test;

import com.szj.aop.base.UserService;
import com.szj.aop.jdkProxy.MyBeanFactory;
import com.szj.aop.zhujie.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void jdkProxyTest(){
        UserService userService = MyBeanFactory.createService();
        userService.addUser();
        userService.deleteUser();
        userService.updateUser();
    }

    @org.junit.Test
    public void cgligTest(){
        UserService userService = com.szj.aop.cglib.MyBeanFactory.createService();
        userService.addUser();
        userService.deleteUser();
        userService.updateUser();
    }

    @org.junit.Test
    public void springAopHalfAuto(){
        String xmlPath = "halfAop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }

    @org.junit.Test
    public void springAopAuto(){
        String xmlPath = "autoAop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }

    @org.junit.Test
    public void aspectJAop(){
        String xmlPath = "aspectJAop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }

    @org.junit.Test
    public void zhujieAop(){
        String xmlPath = "zhujieAop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        StudentService studentService = (StudentService) applicationContext.getBean("studentId");
        studentService.study();
    }
}
