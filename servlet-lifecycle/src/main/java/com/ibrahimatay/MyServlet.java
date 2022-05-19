package com.ibrahimatay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ServletConfigClass",urlPatterns={"/MyServlet"})
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Lifecycle#init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Lifecycle#doGet");
        System.out.println("Lifecycle#doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Lifecycle#doPost");
        System.out.println("Lifecycle#doPost");
    }

    @Override
    public void destroy() {
        System.out.println("Lifecycle#destroy");
    }
}
