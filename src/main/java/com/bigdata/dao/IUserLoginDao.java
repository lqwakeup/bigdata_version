package com.bigdata.dao;

import com.bigdata.pojo.UserLogin;

import java.util.List;

public interface IUserLoginDao {
    //查找用户
    UserLogin findUserByStuId(String stuId);
    //测试数据库
    List<UserLogin> findUsers();
    //修改密码
    void updateUser(UserLogin user);

    //test
    void insertUser(UserLogin user);
}
