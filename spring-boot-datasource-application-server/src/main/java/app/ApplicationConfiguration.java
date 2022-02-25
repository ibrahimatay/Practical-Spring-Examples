package app;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {
        "configuration", "dao", "controller"
})
public class ApplicationConfiguration {
}
