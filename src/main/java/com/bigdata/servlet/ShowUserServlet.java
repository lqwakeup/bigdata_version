package com.bigdata.servlet;

import com.bigdata.pojo.User;
import com.bigdata.service.IUserService;
import com.bigdata.utils.JSONResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showUser")
public class ShowUserServlet extends HttpServlet {

    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IUserService userService = ac.getBean("userService",IUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String tel = null;
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("tel")){
                tel = cookie.getValue();
            }
        }

        User user = userService.findUserBytel(tel);
        if(user!=null){
            JSONResult.JSONReturnWithData(user.getId(),user.getName(),user.getTel(),resp);
        }
    }
}
