package com.upchina.runoob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anjunli on  2021/6/25
 * 通过 Servlet 删除 Cookie
 * 删除 Cookie 是非常简单的。如果您想删除一个 cookie，那么您只需要按照以下三个步骤进行：
 *
 * 读取一个现有的 cookie，并把它存储在 Cookie 对象中。
 * 使用 setMaxAge() 方法设置 cookie 的年龄为零，来删除现有的 cookie。
 * 把这个 cookie 添加到响应头。
 **/
@WebServlet(name = "readCookie",urlPatterns = "/readCookie")
public class ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=null;
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String title="Delete Cookie Demo";
        String docType="<!DOCTYPE html>\n";
        writer.println(docType+
                "<html>\n"+
                "<head><title>"+title+"</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n");
        if(cookies!=null){
            writer.println("<h2>Cookie名称和值</h2>");
            for(int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if (cookie.getName().equalsIgnoreCase("name")){
                    //将时间设置为0，就是删除了这个cookie
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    writer.println("已删除的Cookie："+cookie.getName()+"<br/>");
                }
                writer.println("名称："+cookie.getName()+",");
                writer.println("值："+cookie.getValue());
            }
        }else{
            writer.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
