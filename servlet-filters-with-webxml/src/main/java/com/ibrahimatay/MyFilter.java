package com.ibrahimatay;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter#init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("MyFilter#doFilter - invoked before");
        System.out.println("MyFilter#doFilter - invoked before");

        chain.doFilter(request, response);

        printWriter.println("MyFilter#doFilter - invoked after");
        System.out.println("MyFilter#doFilter - invoked after");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter#destroy");
    }
}