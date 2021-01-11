package com.bigdata.service.impl;

import com.bigdata.dao.ICallDao;
import com.bigdata.dao.IUserDao;
import com.bigdata.pojo.Call;
import com.bigdata.service.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "callService")
public class CallServiceImpl implements ICallService {
    @Autowired
    private ICallDao callDao;

    @Override
    public List<Call> findCallsByTelId(Integer telid) {
        return callDao.findCallsByTelId(telid);
    }
}
