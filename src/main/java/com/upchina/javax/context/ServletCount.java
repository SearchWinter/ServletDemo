package com.upchina.javax.context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anjunli on 2021/12/18.
 * 通过设置ServletContext属性，来实现Servlet直接的数据通信
 **/
@WebServlet("/servletCount")
public class ServletCount extends HttpServlet {
    public int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charSet=UTF-8");
        getServletContext().setAttribute("count", count++);

        PrintWriter writer = resp.getWriter();
        writer.write("ServletContext属性配置");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
