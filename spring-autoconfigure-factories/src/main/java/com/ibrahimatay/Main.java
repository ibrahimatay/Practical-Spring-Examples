package com.ibrahimatay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    /*
    * https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot-autoconfigure/src/main/resources/META-INF/spring.factories
    * https://www.baeldung.com/spring-boot-custom-starter
    * https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/boot-features-developing-auto-configuration.html
    * */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");
    }
}