package com.bigdata.dao.impl;

import com.bigdata.dao.IAdminDao;
import com.bigdata.pojo.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "adminDao")
public class AdminDaoImpl implements IAdminDao {
    @Autowired
    private QueryRunner runner;

    @Override
    public Admin findAdminByName(String name) {
        try{
            List<Admin> admins = runner.query("select * from admin where username = ?",new BeanListHandler<Admin>(Admin.class),name);
            if(admins.size()>1){
                throw new RuntimeException("结果不唯一，数据集有问题");
            }
            if(admins.size() == 0){
                return null;
            }
            return admins.get(0);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
