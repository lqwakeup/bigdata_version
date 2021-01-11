package com.bigdata.service.impl;

import com.bigdata.dao.ITDateDao;
import com.bigdata.pojo.TDate;
import com.bigdata.service.ITDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "dateService")
public class TDateServiceImpl implements ITDateService {

    @Autowired
    private ITDateDao dateDao;

    @Override
    public TDate findDatebyId(Integer id) {
        return dateDao.findDatebyId(id);
    }
}
