package com.bigdata.service;

import com.bigdata.pojo.User;

import java.util.List;

public interface IUserService {
    User findUserBytel(String tel);
    User findUserById(Integer id);
    List<User> findAllUser();
}
