package com.szj.test;

import com.szj.aop.zhujie.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:zhujieAop.xml")
public class ZhujieAop {

    @Autowired
    private StudentService studentService;
    @Test
    public void test(){
        studentService.study();
    }
}
