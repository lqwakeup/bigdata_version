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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showAll")
public class ShowAllServlet extends HttpServlet {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
    IUserService userService = applicationContext.getBean("userService",IUserService.class);
    ICallService callService = applicationContext.getBean("callService",ICallService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ArrayList<Call> arrayCalls = new ArrayList<Call>();
        ArrayList<String> arrayNames = new ArrayList<String>();
        List<User> users = userService.findAllUser();
        for(User user:users){
            List<Call> calls = callService.findCallsByTelId(user.getId());
            for(Call call:calls){
                if(call.getDateid() == 1){
                    arrayCalls.add(call);
                    arrayNames.add(user.getName());
                }
            }
        }

        for (int i = 0; i < arrayCalls.size(); i++) {
            for (int j = 0; j < arrayCalls.size(); j++) {
                if (arrayCalls.get(i).getTelid() == arrayCalls.get(j).getTelid()){
                    arrayCalls.remove(arrayCalls.get(i));
                    arrayNames.remove(arrayNames.get(i));
                }
            }
        }

        JSONResult.JSONReturnAll(arrayCalls,arrayNames,resp);

    }
}
