package com.ibrahimatay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /*
        http://localhost:8080/actuator/metrics/com.ibrahimatay.fileStore
        http://localhost:8080/actuator/metrics
        * */

        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}