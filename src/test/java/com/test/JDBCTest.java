package com.test;

import com.bigdata.service.ITDateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        ITDateService dateService = applicationContext.getBean("dateService",ITDateService.class);

        System.out.println(dateService.findDatebyId(34));
    }




}
