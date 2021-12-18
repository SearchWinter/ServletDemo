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
 * 获取ServletContext中的属性，验证数据通信
 **/
@WebServlet("/countShow")
public class ServletCountShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charSet=UTF-8");
        int count = (int)getServletContext().getAttribute("count");
        PrintWriter writer = resp.getWriter();
        if(count==0){
            writer.write("/servletCount 目前没有人访问");
        }else{
            writer.write("/servletCount 目前总的访问人数为"+count);
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
