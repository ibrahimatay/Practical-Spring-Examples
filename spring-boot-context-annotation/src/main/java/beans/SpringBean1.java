package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean1 {
    @Autowired
    private SpringBean2 springBean2;
    @Autowired
    private SpringBean3 springBean3;

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(String.format("%s postConstruct with %s and %s",
                getClass().getSimpleName(),
                springBean2.getClass().getSimpleName(),
                springBean3.getClass().getSimpleName()
        ));
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
