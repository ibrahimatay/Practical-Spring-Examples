package beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean4 {
    public SpringBean4() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }
}
