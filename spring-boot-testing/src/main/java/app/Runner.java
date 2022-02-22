package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ReportService;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.registerShutdownHook();

            ReportService service = context.getBean(ReportService.class);
            service.execute();
        }
    }
}
