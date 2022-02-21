package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TaxRateService;

public class Runner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)){
            context.registerShutdownHook();

            TaxRateService service = context.getBean(TaxRateService.class);
            service.getTaxRate();
        }
    }
}
