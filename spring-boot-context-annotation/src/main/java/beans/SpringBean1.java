package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 implements DisposableBean {
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

    @PreDestroy
    public void preDestroy() {
        System.out.println(getClass().getSimpleName() + "::preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(getClass().getSimpleName() + "::destroy");
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
