package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
        "annotations", "aspects", "service"
})
public class ApplicationConfiguration {
}
