package com.bigdata.dao.impl;

import com.bigdata.dao.ITDateDao;
import com.bigdata.pojo.TDate;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "dateDao")
public class TDateDaoImpl implements ITDateDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public TDate findDatebyId(Integer id) {
        try{
            List<TDate> tDates = runner.query("select * from ct_date where id = ?",new BeanListHandler<TDate>(TDate.class),id);
            if(tDates.size()==0){
                return null;
            }
            if(tDates.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return tDates.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
