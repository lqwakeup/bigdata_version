package com.bigdata.utils;

import com.alibaba.fastjson.JSON;
import com.bigdata.pojo.ResultObjs;

import javax.servlet.http.HttpServletResponse;

public class JSONResults {
    public JSONResults(){

    }

    /*
    将状态码以及请求数据转化为json格式传给前端
     */
    public static void JSONReturnWithData(String recode, Object data, HttpServletResponse response){
        try{
            ResultObjs resultObj = new ResultObjs();
            resultObj.setRecode(recode);
            resultObj.setDesc(data);
            String resultStr = JSON.toJSONString(resultObj);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
