package com.bigdata.dao;

import com.bigdata.pojo.User;

import java.util.List;

public interface IUserDao {

    User findUserBytel(String tel);

    User findUserById(Integer id);

    //找所有用户的信息
    List<User> findAllUser();
}
