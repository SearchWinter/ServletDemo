package com.upchina.runoob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anjunli on  2021/6/25
 * 重定向请求到另一个网页的最简单的方式是使用 response 对象的 sendRedirect()
 * public void HttpServletResponse.sendRedirect(String location) throws IOException
 * 方法该方法把响应连同状态码和新的网页位置发送回浏览器
 **/
@WebServlet(name = "redirect",urlPatterns = "/redirect")
public class Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //重定向
//        resp.sendRedirect("/page/hello.html");
        //同样效果
        String site = new String("http://www.runoob.com");
        //设置状态码 302 所请求的页面已经临时转移到一个新的 URL。
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", site);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
