package com.bigdata.service.impl;

import com.bigdata.dao.IUserLoginDao;
import com.bigdata.pojo.UserLogin;
import com.bigdata.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private IUserLoginDao userDao;
    public UserLogin findUserByStuId(String stuId) {
        return  userDao.findUserByStuId(stuId);
    }

    @Override
    public List<UserLogin> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public void updateUser(UserLogin user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(UserLogin user) {
        userDao.insertUser(user);
    }
}
