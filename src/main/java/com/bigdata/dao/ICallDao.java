package com.bigdata.dao;

import com.bigdata.pojo.Call;

import java.util.List;

public interface ICallDao{

    List<Call> findCallsByTelId(Integer telid);
}
