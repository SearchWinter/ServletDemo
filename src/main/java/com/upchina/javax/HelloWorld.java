package com.upchina.javax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Created by anjunli on  2021/5/13
 * tomcat启动，HttpServlet简单示例
 **/
//@WebServlet("/test")
//多重映射
//@WebServlet(urlPatterns = {"/test","/test2"})
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Servlet 初始化";
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            contextClassLoader.loadClass("com.upchina.javax.HelloWorld");
            System.out.println(contextClassLoader.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(contextClassLoader);
        URL resource = Thread.currentThread().getContextClassLoader().getResource("com.upchina.javax.HelloWorld.class");
        System.out.println("URL:"+resource);
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        //获取表单参数的值
        String name = request.getParameter("name");
        System.out.println(name);
        //设置请求的编码格式，中文乱码
        response.setCharacterEncoding("utf-8");
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        //转发
//        request.getRequestDispatcher("/hello.html").forward(request,response);
    }

    @Override
    public void destroy()
    {
        // 什么也不做
    }
}
