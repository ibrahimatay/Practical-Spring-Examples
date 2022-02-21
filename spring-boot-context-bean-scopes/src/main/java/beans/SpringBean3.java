package beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SpringBean3 {
    public SpringBean3() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Lazy Singleton Bean");
    }
}
