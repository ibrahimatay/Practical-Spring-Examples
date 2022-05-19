package com.ibrahimatay.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(String.format("MySessionListener#sessionCreated - SessionId:  %s", se.getSession().getId()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(String.format("MySessionListener#sessionDestroyed - SessionId:  %s", se.getSession().getId()));
    }
}
