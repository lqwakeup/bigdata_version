package com.bigdata.servlet;

import com.bigdata.pojo.User;
import com.bigdata.pojo.UserLogin;
import com.bigdata.service.IUserLoginService;
import com.bigdata.service.IUserService;
import com.bigdata.utils.JSONResults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
        String tel = req.getParameter("stuId");
//        String psd = req.getParameter("psd");

        Cookie cookie = new Cookie("tel",tel);
        resp.addCookie(cookie);

        User user = userService.findUserBytel(tel);
        if(user!=null){
            JSONResults.JSONReturnWithData("0","登陆成功",resp);
        }else{
            JSONResults.JSONReturnWithData("2","用户不存在",resp);
        }


    }
}
