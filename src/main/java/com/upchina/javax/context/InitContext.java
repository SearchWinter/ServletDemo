package com.upchina.javax.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.SerializablePermission;
import java.util.Enumeration;

/**
 * Created by anjunli on 2021/12/18.
 * 通过web.xml来设置ServletContext初始值，在页面进行展示
 **/
@WebServlet("/initContext")
public class InitContext extends HttpServlet {
    private static final long serializableID = 3477265329L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //获取ServletContext
        ServletContext servletContext = getServletContext();
        //获取参数
        Enumeration<String> initParams = servletContext.getInitParameterNames();

        PrintWriter writer = resp.getWriter();

        while(initParams.hasMoreElements()){
            String nextElement = initParams.nextElement();
            String initParamValue = servletContext.getInitParameter(nextElement);
            writer.write(nextElement+" : "+initParamValue+"<br/>");
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
