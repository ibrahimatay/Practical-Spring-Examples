package app;

import configuration.DataSourceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import service.EmployeeService;

@ComponentScan(value = {
        "dao","configuration","model","service"
})
public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class)) {
            context.registerShutdownHook();

            EmployeeService employeeService = context.getBean(EmployeeService.class);

            /*
            employeeService.saveEmployeeWithoutTransaction();
            employeeService.saveEmployeeWithTransaction();


            employeeService.callRequiredWithoutCurrentTransaction();
            employeeService.callRequiredWithCurrentTransaction();

            employeeService.callSupportsWithoutCurrentTransaction();
            employeeService.callSupportsWithCurrentTransaction();

            employeeService.callMandatoryWithoutCurrentTransaction();
            employeeService.callMandatoryWithCurrentTransaction();

            employeeService.callRequiresNewWithoutCurrentTransaction();
            employeeService.callRequiresNewWithCurrentTransaction();

            employeeService.callNotSupportedWithoutCurrentTransaction();
            employeeService.callNotSupportedWithCurrentTransaction();

            employeeService.callNeverWithoutCurrentTransaction();
            employeeService.callNeverWithCurrentTransaction();

            employeeService.callNestedWithoutCurrentTransaction();
            employeeService.callNestedWithCurrentTransaction();

            */

            try {
                employeeService.methodWithUncheckedExceptionNotCausingRollback();
            } catch (Exception e) {
                System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
            }

            try {
                employeeService.methodWithCheckedExceptionCausingRollback();
            } catch (Exception e) {
                System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
            }
        }
    }
}
