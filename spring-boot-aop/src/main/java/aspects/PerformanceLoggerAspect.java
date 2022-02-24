package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Aspect
@Component
public class PerformanceLoggerAspect {
    @Around("@annotation(annotations.PerformanceLogger)")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);

            System.out.println(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
}
