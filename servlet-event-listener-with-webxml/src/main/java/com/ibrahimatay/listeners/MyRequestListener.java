package com.ibrahimatay.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(String.format("MyRequestListener#requestInitialized - IP:%s", sre.getServletRequest().getRemoteAddr()));
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(String.format("MyRequestListener#requestDestroyed - IP:%s", sre.getServletRequest().getRemoteAddr()));
    }
}
