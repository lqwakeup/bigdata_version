package com.test;

import com.bigdata.service.IAdminService;
import com.bigdata.service.ITDateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminService adminService = applicationContext.getBean("adminService",IAdminService.class);

        System.out.println(adminService.findAdminByName("admin"));
    }
}
