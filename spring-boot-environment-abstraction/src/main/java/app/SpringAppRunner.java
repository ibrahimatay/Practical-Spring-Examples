package app;

import dao.AuditLogDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"dao"})
public class SpringAppRunner implements CommandLineRunner {

    @Autowired
    private AuditLogDataStore auditLogDataStore;

    @Override
    public void run(String... args) throws Exception {
        auditLogDataStore.write();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringAppRunner.class)
                .profiles("prod")
                .run(args);
    }
}
