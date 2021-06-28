package com.upchina.jetty;

import com.upchina.javax.HelloWorld;
import com.upchina.javax.ServletLife;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by anjunli on  2021/5/13
 * 通过main方法启动Server,通过浏览进行访问 localhost:port
 **/
public class ApiServer {
    private static Server server;
    private static int httpPort;

    public static void main(String[] args) {
        startServer();
    }

    public ApiServer(Server server, int httpPort) {
        server = server;
        httpPort = httpPort;
    }

    public static void startServer()  {
        server =new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);
        //添加servlet
        contextHandler.addServlet(new ServletHolder(new HelloWorld()),"/test2");
        contextHandler.addServlet(new ServletHolder(new ServletLife()),"/life");
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            server.stop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}
