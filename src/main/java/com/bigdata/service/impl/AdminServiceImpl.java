package com.bigdata.service.impl;

import com.bigdata.dao.IAdminDao;
import com.bigdata.pojo.Admin;
import com.bigdata.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;
    @Override
    public Admin findAdminByName(String name) {
        return adminDao.findAdminByName(name);
    }
}
