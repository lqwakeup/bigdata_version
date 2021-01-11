package com.bigdata.servlet;

import com.bigdata.dao.IAdminDao;
import com.bigdata.pojo.Admin;
import com.bigdata.service.IAdminService;
import com.bigdata.utils.JSONResult;
import com.bigdata.utils.JSONResults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IAdminService adminService = ac.getBean("adminService",IAdminService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String psd = req.getParameter("psd");

        Admin admin =  adminService.findAdminByName(name);

        if(admin != null){
            if(admin.getPassword().equals(psd)){
                JSONResults.JSONReturnWithData("0", "登陆成功", resp);
            }else {
                JSONResults.JSONReturnWithData("1","密码错误",resp);
            }
        }else{
            JSONResults.JSONReturnWithData("2","用户不存在",resp);
        }

    }
}
