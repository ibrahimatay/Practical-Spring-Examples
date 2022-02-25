package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import service.EmployeeService;

@ComponentScan(value = {
    "configuration", "dao", "service"
})
public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class)) {
            context.registerShutdownHook();

            EmployeeService service = context.getBean(EmployeeService.class);
            service.findAll().forEach(System.out::println);
        }
    }
}
