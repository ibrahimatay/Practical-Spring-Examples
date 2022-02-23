package app;

import dao.AuditLogDataStore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.registerShutdownHook();

            // Activate profile
            context.getEnvironment().setActiveProfiles("prod");
            context.register(ApplicationConfiguration.class);
            context.refresh();

            // profile should be activated with VM property -Dspring.profiles.active=database

            AuditLogDataStore auditLogDataStore = context.getBean(AuditLogDataStore.class);
            auditLogDataStore.write();
        }
    }
}
