package com.szj.aop.zhujie;

import org.springframework.stereotype.Service;

@Service("studentId")
public class StudentImpl implements StudentService {
    @Override
    public void study() {
        System.out.println("学习");
    }
}
