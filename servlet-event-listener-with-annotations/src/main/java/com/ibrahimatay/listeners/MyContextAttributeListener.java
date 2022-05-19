package com.ibrahimatay.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println(String.format("MyContextAttributeListener#attributeAdded - attribute added:%s:%s", scae.getName(), scae.getValue()));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println(String.format("MyContextAttributeListener#attributeRemoved - attribute added:%s:%s", scae.getName(), scae.getValue()));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println(String.format("MyContextAttributeListener#attributeReplaced - attribute added:%s:%s", scae.getName(), scae.getValue()));
    }
}
