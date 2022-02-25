package app;

import dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {
        "dao","configuration","model"
})
public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class)) {
            context.registerShutdownHook();

            EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

            employeeDao.findEmployees().forEach(System.out::println);
            System.out.println(employeeDao.findEmployeeWithHighestSalary());
        }
    }
}
