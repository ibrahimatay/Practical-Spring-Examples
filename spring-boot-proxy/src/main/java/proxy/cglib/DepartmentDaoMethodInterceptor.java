package proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DepartmentDaoMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before: "+ method.getName());
        Object result= methodProxy.invokeSuper(object, args);
        System.out.println("after: "+ method.getName());
        return result;
    }
}
