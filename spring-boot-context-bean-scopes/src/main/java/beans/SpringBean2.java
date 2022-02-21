package beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SpringBean2 {
    public SpringBean2() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Prototype Bean");
    }
}
