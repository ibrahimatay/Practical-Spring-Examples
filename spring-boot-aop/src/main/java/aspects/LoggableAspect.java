package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggableAspect {
    @Before("@annotation(annotations.Loggable)")
    public void executingLoggableAdvice() {
        System.out.println("Executing loggable Advice...");
    }

    @After("@annotation(annotations.Loggable)")
    public void executedLoggableAdvice() {
        System.out.println("Executed loggable Advice...");
    }
}
