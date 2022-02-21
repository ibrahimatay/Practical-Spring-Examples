package app;

import beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        /*
        https://www.baeldung.com/spring-bean-scopes
        https://www.journaldev.com/21039/spring-bean-scopes
        * */

        try (AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)){
            context.registerShutdownHook();

            SpringBean1 springBean1 = context.getBean(SpringBean1.class);
            springBean1.sayHello();
        }
    }
}
