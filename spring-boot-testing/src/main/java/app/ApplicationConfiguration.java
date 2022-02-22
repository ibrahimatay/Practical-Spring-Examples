package app;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {
        "component", "service"
})
public class ApplicationConfiguration {
}
