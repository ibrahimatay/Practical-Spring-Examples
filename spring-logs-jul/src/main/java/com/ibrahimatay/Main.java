package com.ibrahimatay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private Logger loggerA = Logger.getLogger("app.service.a");
    private Logger loggerB = Logger.getLogger("app.service.b");
    private Logger loggerC = Logger.getLogger("app.service.c");
    private Logger loggerD = Logger.getLogger("app.service.d");
    private Logger loggerE = Logger.getLogger("app.service.e");
    private Logger loggerF = Logger.getLogger("app.service.f");
    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(
            Main.class.getResourceAsStream("/logging.properties")
        );

        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        loggerA.log(Level.INFO, "INFO Message from serviceA");
        loggerA.log(Level.WARNING, "WARNING Message from serviceA");
        loggerA.log(Level.FINEST, "FINEST Message from serviceA");

        loggerB.log(Level.INFO, "INFO Message from serviceB");
        loggerB.log(Level.WARNING, "WARNING Message from serviceB");
        loggerB.log(Level.FINEST, "FINEST Message from serviceB");

        loggerC.log(Level.INFO, "INFO Message from serviceC");
        loggerC.log(Level.WARNING, "WARNING Message from serviceC");
        loggerC.log(Level.FINEST, "FINEST Message from serviceC");

        loggerD.log(Level.INFO, "INFO Message from serviceD");
        loggerD.log(Level.WARNING, "WARNING Message from serviceD");
        loggerD.log(Level.FINEST, "FINEST Message from serviceD");

        loggerE.log(Level.INFO, "INFO Message from serviceE");
        loggerE.log(Level.WARNING, "WARNING Message from serviceE");
        loggerE.log(Level.FINEST, "FINEST Message from serviceE");

        loggerF.log(Level.INFO, "INFO Message from serviceF");
        loggerF.log(Level.WARNING, "WARNING Message from serviceF");
        loggerF.log(Level.FINEST, "FINEST Message from serviceF");
    }
}