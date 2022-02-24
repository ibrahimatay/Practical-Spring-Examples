package app;

import model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.StudentService;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.registerShutdownHook();

            StudentService service = context.getBean(StudentService.class);
            service.save(new Student());
        }
    }
}
