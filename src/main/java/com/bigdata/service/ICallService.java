package com.bigdata.service;

import com.bigdata.pojo.Call;

import java.util.List;

public interface ICallService {
    List<Call> findCallsByTelId(Integer telid);
}
