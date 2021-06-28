package com.upchina.runoob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by anjunli on  2021/6/25
 * Servlet Cookie处理
 *
 **/
@WebServlet(name = "setCookie",urlPatterns = "/setCookie")
public class SetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie
        Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"), "utf-8"));
        Cookie url = new Cookie("url", req.getParameter("url"));

        //设置cookie时间,单位：秒
        name.setMaxAge(60);
        url.setMaxAge(60);

        //在响应头里面添加cookie
        resp.addCookie(name);
        resp.addCookie(url);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String title = "设置 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + req.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + req.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
