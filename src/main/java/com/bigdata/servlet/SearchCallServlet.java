package com.bigdata.servlet;

import com.bigdata.pojo.Call;
import com.bigdata.pojo.User;
import com.bigdata.service.ICallService;
import com.bigdata.service.IUserService;
import com.bigdata.utils.JSONResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchCall")
public class SearchCallServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IUserService userService = ac.getBean("userService",IUserService.class);
    ICallService callService = ac.getBean("callService",ICallService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf=8");

        String tel = req.getParameter("tel");

        User user = userService.findUserBytel(tel);
        List<Call> calls = callService.findCallsByTelId(user.getId());

        JSONResult.JSONReturnCall(calls,resp);
    }
}
