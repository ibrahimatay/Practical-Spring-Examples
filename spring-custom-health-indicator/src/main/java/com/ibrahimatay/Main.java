package com.ibrahimatay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /*
        http://localhost:8080/actuator/health
        * */
        SpringApplication.run(Main.class, args);
    }
}