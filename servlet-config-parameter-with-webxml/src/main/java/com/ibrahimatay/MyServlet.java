package com.ibrahimatay;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("Hello to doGet");
        System.out.println("Call the doGet");

        ServletConfig config = getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(String.format("Username: %s Password: %s", username, password));

        ServletContext context = getServletContext();
        String rootPath = context.getInitParameter("rootPath");
        System.out.println(String.format("rootPath: %s", rootPath));

        Enumeration<String> names = context.getInitParameterNames();
        while (names.hasMoreElements()){
            String currentName = names.nextElement();
            System.out.println(String.format("%s: %s", currentName, context.getInitParameter(currentName)));
        }
    }
}