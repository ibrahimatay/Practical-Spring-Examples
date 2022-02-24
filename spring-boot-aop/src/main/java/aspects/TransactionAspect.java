package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
    @Before("@annotation(annotations.Transaction)")
    public void executingTransactionAdvice() {
        System.out.println("Executing loggable Advice...");
    }

    @Around("@annotation(annotations.Transaction)")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("The transaction in continue...");
        try {
            return proceedingJoinPoint.proceed();
        } finally {

        }
    }

    @After("@annotation(annotations.Transaction)")
    public void executedTransactionAdvice() {
        System.out.println("Executed loggable Advice...");
    }

}
