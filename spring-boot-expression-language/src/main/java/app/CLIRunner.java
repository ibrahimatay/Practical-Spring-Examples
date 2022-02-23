package app;

import beans.SpringBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(value = "beans")
@PropertySource("classpath:application.properties")
public class CLIRunner implements CommandLineRunner {

    private final SpringBean springBean;

    public CLIRunner(SpringBean springBean) {
        this.springBean = springBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(CLIRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("getAppDefaultProperty: " + springBean.getAppDefaultProperty());
        System.out.println("getAppRandomProperty: " + springBean.getAppRandomProperty());
        System.out.println("getJavaHome: " + springBean.getJavaHome());
        System.out.println("getMavenHome: " + springBean.getMavenHome());
    }
}
