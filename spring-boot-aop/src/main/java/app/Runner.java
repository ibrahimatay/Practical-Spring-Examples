package app;

import model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.StudentService;
import service.TransactionHistoryService;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.registerShutdownHook();

            StudentService service = context.getBean(StudentService.class);
            service.save(new Student());

            TransactionHistoryService historyService = context.getBean(TransactionHistoryService.class);
            historyService.saveTransactionData(
                    "A001",
                    "amount=50",
                    "private-key-5232"
            );
        }
    }
}
