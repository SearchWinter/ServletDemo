package com.upchina.runoob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anjunli on  2021/6/25
 * 点击计数器
 **/
@WebServlet(name = "hitCount",urlPatterns = "/hitCount")
public class PageHitCounter extends HttpServlet {
    private Long hitCount;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用一次服务，添加一次
        hitCount++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html><head><title>总点击量</title></head>"+
                "<h2>"+hitCount+"</h2>"+
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void destroy() {
        //可以选择保存到数据库
        System.out.println("hitCount最终的值为："+hitCount);
    }

    @Override
    public void init() throws ServletException {
        //重置计数器,可以从数据库读取
        hitCount=0L;
    }
}
