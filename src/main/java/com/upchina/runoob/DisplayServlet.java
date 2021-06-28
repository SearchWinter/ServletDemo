package com.upchina.runoob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by anjunli on  2021/6/25
 **/
@WebServlet(name = "display",urlPatterns = "/display")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
            // 设置刷新自动加载时间为 5 秒
            response.setIntHeader("Refresh", 5);
            // 设置响应内容类型
            response.setContentType("text/html;charset=UTF-8");

            //使用默认时区和语言环境获得一个日历
            Calendar cale = Calendar.getInstance();
            //将Calendar类型转换成Date类型
            Date tasktime=cale.getTime();
            //设置日期输出的格式
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //格式化输出
            String nowTime = df.format(tasktime);
            PrintWriter out = response.getWriter();
            String docType =
                    "<!DOCTYPE html>\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>test</title></head>\n"+
                    "<p>当前时间是：" + nowTime + "</p>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
