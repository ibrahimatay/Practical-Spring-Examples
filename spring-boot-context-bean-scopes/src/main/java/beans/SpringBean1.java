package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope // singleton - default
// @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringBean1 {
    public SpringBean1() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
