package controller;

import beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SpringBeanController {
    @Controller
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class springBeanController {
        @Autowired
        private SpringBean1 springBean1;
        @Autowired
        private SpringBean2 springBean2;
        @Autowired
        private SpringBean3 springBean3;
        @Autowired
        private SpringBean4 springBean4;
        @Autowired
        private SpringBean5 springBean5;

        @RequestMapping
        @ResponseBody
        public String index() {
            return "<pre>" +
                    springBean1 + " - Singleton\n" +
                    springBean2 + " - Prototype\n" +
                    springBean3 + " - Request Scope\n" +
                    springBean4 + " - Session Scope\n" +
                    springBean5 + " - Application Scope\n" +
                    "</pre>";
        }
    }
}
