package com.ibrahimatay;



import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    static class HelloWorldServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            PrintWriter writer = resp.getWriter();
            writer.print("Hello world");
            System.out.println("Hello world");
        }
    }

    static class StatusServlet extends HttpServlet {
        final int status;

        public StatusServlet(int status) {
            this.status = status;
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            resp.setStatus(status);
        }
    }

    public static void main(String[] args) throws Exception {
        final int HTTP_BIND_PORT = 8080;

        Server server = new Server(HTTP_BIND_PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.setContextPath("/servlet");
        context.addServlet(new ServletHolder(new HelloWorldServlet()), "/hello");
        context.addServlet(new ServletHolder(new StatusServlet(404)), "/404");

        server.setHandler(context);
        server.start();

        System.out.println("Started!");
    }
}