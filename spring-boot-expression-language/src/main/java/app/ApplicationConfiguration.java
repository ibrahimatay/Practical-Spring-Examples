package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = "beans")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
}
