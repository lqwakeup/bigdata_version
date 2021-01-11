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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/showMonth")
public class ShowMonthServlet extends HttpServlet {
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
        resp.setContentType("text/html;utf-8");

        String tel = null;
        Cookie[] cookies = req.getCookies();

        for(Cookie cookie:cookies){
            if(cookie.getName().equals("tel")){
                tel = cookie.getValue();
            }
        }

        User user = userService.findUserBytel(tel);
        List<Call> calls = callService.findCallsByTelId(user.getId());

        ArrayList<Call> calls1 = new ArrayList<Call>();
        for(Call call:calls){
            if(call.getDateid() == 2){
                calls1.add(call);
            }
            if(call.getDateid() == 34){
                calls1.add(call);
            }
            if(call.getDateid() == 63){
                calls1.add(call);
            }
            if(call.getDateid() == 95){
                calls1.add(call);
            }
            if(call.getDateid() == 126){
                calls1.add(call);
            }
            if(call.getDateid() == 158){
                calls1.add(call);
            }
            if(call.getDateid() == 189){
                calls1.add(call);
            }
            if(call.getDateid() == 221){
                calls1.add(call);
            }
            if(call.getDateid() == 253){
                calls1.add(call);
            }
            if(call.getDateid() == 284){
                calls1.add(call);
            }
            if(call.getDateid() == 316){
                calls1.add(call);
            }
            if(call.getDateid() == 347){
                calls1.add(call);
            }
//            arrayHash.add(hashMap);
        }

        for (int i = 0; i < calls1.size(); i++) {
            for (int j = 0; j < calls1.size(); j++) {
                if (calls1.get(i).getDateid() == calls1.get(j).getDateid()){
                    calls1.remove(calls1.get(i));
                }
            }
        }

        JSONResult.JSONReturnCall(calls1,resp);
    }
}
