package com.test;

import com.bigdata.pojo.User;
import com.bigdata.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        IUserService userService = applicationContext.getBean("userService",IUserService.class);

        List<User> users =  userService.findAllUser();
        for(User user:users){
            System.out.println(user);
        }


    }
}
