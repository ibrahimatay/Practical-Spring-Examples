package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.EmployeeService;

@ComponentScan(value = {
        "dao","service","model"
})
@EnableAspectJAutoProxy
public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class)) {
            context.registerShutdownHook();

            EmployeeService employeeService = context.getBean(EmployeeService.class);
            employeeService.queryEmployee();
        }
    }
}
