package com.bigdata.service.impl;

import com.bigdata.dao.IUserDao;
import com.bigdata.pojo.User;
import com.bigdata.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User findUserBytel(String tel) {
        return userDao.findUserBytel(tel);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
