package com.upchina.jetty;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anjunli on  2021/5/20
 * ServletContext示例
 **/

@WebServlet(name="ScServlet1",urlPatterns="/sc1")
public class ScServlet1 extends HttpServlet {
    public ScServlet1() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //获取ServletContext对象引用
        ServletContext servletContext = this.getServletContext();
//        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        servletContext.setAttribute("tom","cat");
        writer.println("给ServletContext添加值");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
