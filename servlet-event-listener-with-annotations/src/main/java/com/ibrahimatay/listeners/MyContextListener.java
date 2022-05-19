package com.ibrahimatay.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // It is called when the servlet is ready to service requests.
        System.out.println("MyContextListener#contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // It is called just before servlet context shut down.
        System.out.println("MyContextListener#contextDestroyed");
    }
}
