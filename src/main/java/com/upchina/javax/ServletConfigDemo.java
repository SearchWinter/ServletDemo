package com.upchina.javax;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by anjunli on  2021/12/16
 * ServletConfig示例，
 * 获取servletConfig对象： 1、GenericServlet带参数的 init(ServletConfig config)  2、直接调用GenericServlet getServletConfig()
 * 配置Servlet初始化参数:  1、WebServlet  2、web.xml
 **/
@WebServlet(value = "/config",initParams = {@WebInitParam(name="name",value = "编程"),@WebInitParam(name="URL",value = "www.baidu.com")})
public class ServletConfigDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String characterEncoding = resp.getCharacterEncoding();
        System.out.println("characterEncoding: "+characterEncoding);

        //返回一个向客户端发送字符的PrintWriter对象，使用getCharacterEncoding()的字符集，如果没有指定则为ISO-8859-1
        PrintWriter writer = resp.getWriter();
        //得到当前Servlet的ServletConfig对象
        ServletConfig config = getServletConfig();
        //得到Servlet名
        String servletName = config.getServletName();
        System.out.println("servletName:"+servletName);

        //返回所有初始化参数名的Enumeration
        Enumeration<String> initParam = config.getInitParameterNames();
        while(initParam.hasMoreElements()){
            String initParamName  = initParam.nextElement();
            //根据参数名称获取参数值
            String initParamValue  = config.getInitParameter(initParamName );
            //向页面输出
            writer.write(initParamName+" : "+initParamValue+"<br/>" );
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
