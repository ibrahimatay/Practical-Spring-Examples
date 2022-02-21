package beans.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans Start");
        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans End\n");
    }
}
