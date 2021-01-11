package com.bigdata.dao.impl;

import com.bigdata.dao.IUserDao;
import com.bigdata.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public User findUserBytel(String tel) {
        try{
            List<User> users =runner.query("select * from ct_user where tel = ?", new BeanListHandler<User>(User.class),tel);
            if(users.size()==0){
                return null;
            }
            if(users.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return users.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserById(Integer id) {
        try{
            List<User> users =runner.query("select * from ct_user where id = ?", new BeanListHandler<User>(User.class),id);
            if(users.size()==0){
                return null;
            }
            if(users.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return users.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAllUser() {
        try{
            List<User> users = runner.query("select * from ct_user",new BeanListHandler<User>(User.class));
            return users;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
