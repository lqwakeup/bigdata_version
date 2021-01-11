package com.bigdata.dao.impl;

import com.bigdata.dao.ICallDao;
import com.bigdata.pojo.Call;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "callDao")
public class CallDaoImpl implements ICallDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Call> findCallsByTelId(Integer telid) {
        try {
            List<Call> calls = runner.query("select * from ct_call where telid = ?",new BeanListHandler<Call>(Call.class),telid);
            return calls;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
