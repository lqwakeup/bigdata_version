package com.bigdata.dao;

import com.bigdata.pojo.Admin;

public interface IAdminDao {

    Admin findAdminByName(String name);
}
