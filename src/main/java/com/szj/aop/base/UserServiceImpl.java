package com.szj.aop.base;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("增加了一个User");
    }

    @Override
    public void updateUser() {
        System.out.println("更新了一个User");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个User");
    }
}
