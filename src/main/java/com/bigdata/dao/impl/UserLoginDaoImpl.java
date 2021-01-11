package com.bigdata.dao.impl;

import com.bigdata.dao.IUserLoginDao;
import com.bigdata.pojo.UserLogin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userLoginDao")
public class UserLoginDaoImpl implements IUserLoginDao {
    @Autowired
    private QueryRunner runner;

    public UserLogin findUserByStuId(String stuId) {
        try{
            List<UserLogin> users =runner.query("select * from user where stuId = ?", new BeanListHandler<UserLogin>(UserLogin.class),stuId);
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
    public List<UserLogin> findUsers() {
        try {
            List<UserLogin> users = runner.query("select * from user",new BeanListHandler<UserLogin>(UserLogin.class));
            return users;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(UserLogin user) {
        try{
            runner.update("update user set password =? where stuId = ?",user.getPassword(),user.getStuId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(UserLogin user) {
        try{
            runner.update("insert into user(stuId,name)values(?,?)",user.getStuId(),user.getName());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
