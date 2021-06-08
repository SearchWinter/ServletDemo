package com.upchina.javax;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by anjunli on  2021/5/14
 * tomcat启动，体会Servlet的生命周期。
 * 启动、刷新几次、关闭服务看控制台的输出
 **/
@WebServlet("/life")
public class ServletLife implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet正在初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet正在提供服务");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet正在销毁");
    }
}
