package app;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "dao","service","components"
})
public class ApplicationConfiguration {
}
