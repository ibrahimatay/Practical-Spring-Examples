package app;

import beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.registerShutdownHook();

            SpringBean1 springBean1 = context.getBean(SpringBean1.class);
            springBean1.sayHello();

            System.out.println("--------------------------");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
