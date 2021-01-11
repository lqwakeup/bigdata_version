package com.bigdata.service;

import com.bigdata.pojo.Admin;

public interface IAdminService {
    Admin findAdminByName(String name);
}
