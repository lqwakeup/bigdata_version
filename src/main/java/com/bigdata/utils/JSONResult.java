package com.bigdata.utils;

import com.alibaba.fastjson.JSON;
import com.bigdata.pojo.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSONResult {
    public JSONResult(){

    }

    /*
    将状态码以及请求数据转化为json格式传给前端
     */
    public static void JSONReturnWithData(Integer id,String name, String tel, HttpServletResponse response){
        try{
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setTel(tel);
            String resultStr = JSON.toJSONString(user);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnCall(List<Call> callList, HttpServletResponse response){
        try{
            ResultObj resultObj = new ResultObj();
            resultObj.setCalls(callList);
            String resultStr = JSON.toJSONString(resultObj);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnAll(List<Call> calls,List<String> names, HttpServletResponse response){
        try{
            AllResults allResults = new AllResults();
            allResults.setCalls(calls);
            allResults.setNames(names);
            String resultStr = JSON.toJSONString(allResults);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnMonth(HashMap<Integer,Call> hashMaps,HttpServletResponse response){
        try{
            MonthResult monthResult = new MonthResult();
            monthResult.setHashMap(hashMaps);
            String resultStr = JSON.toJSONString(monthResult);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
