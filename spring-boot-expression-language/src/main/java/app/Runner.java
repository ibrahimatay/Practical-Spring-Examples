package app;

import beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Runner {
    public static void main(String[] args) {
        /*
        * https://docs.spring.io/spring-framework/docs/4.3.12.RELEASE/spring-framework-reference/html/expressions.html
        * https://www.baeldung.com/spring-expression-language
        * https://github.com/eugenp/tutorials/tree/master/spring-spel
        * */
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.registerShutdownHook();
            /**
            System.out.println(context.getEnvironment().getProperty("user.home"));
            System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));
            System.out.println(context.getEnvironment().getProperty("MAVEN_HOME"));

            System.out.println(context.getBean(SpringBean.class).getUserHome());
            System.out.println(context.getBean(SpringBean.class).getJavaHome());
            System.out.println(context.getBean(SpringBean.class).getMavenHome());
            **/
            System.out.println(context.getBean(SpringBean.class).getAdditionResult());
            System.out.println(context.getBean(SpringBean.class).getCityName());
            System.out.println(context.getBean(SpringBean.class).getCurrentDate());
            System.out.println(context.getBean(SpringBean.class).getAppRandomProperty());

            ExpressionParser parser = new SpelExpressionParser();
            StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
            evaluationContext.setBeanResolver(new BeanFactoryResolver(context));

            Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
            String message = exp.getValue(String.class);
            System.out.println(message);
        }
    }
}
