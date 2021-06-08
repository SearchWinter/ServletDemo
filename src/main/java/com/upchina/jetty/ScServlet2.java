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
 **/
@WebServlet(name = "ScServlet2",urlPatterns = "/sc2")
public class ScServlet2 extends HttpServlet {
    public ScServlet2() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ServletContext servletContext = this.getServletContext();
        //取出属性值
        String tom = (String) servletContext.getAttribute("tom");
        writer.println(tom);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
