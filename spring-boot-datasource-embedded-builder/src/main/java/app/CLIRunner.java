package app;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
   "configuration", "dao", "service"
})
public class CLIRunner implements CommandLineRunner {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void run(String... args) throws Exception {
        employeeDao.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(CLIRunner.class, args);
    }
}
