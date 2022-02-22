package proxy.jdk;

import dao.DepartmentDAO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DepartmentDAOInvocationHandler implements InvocationHandler {

    private final DepartmentDAO target;

    public DepartmentDAOInvocationHandler(DepartmentDAO departmentDAO) {
        this.target = departmentDAO;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before: "+ method.getName());
        Object result =method.invoke(target, args);
        System.out.println("after: "+ method.getName());
        return result;
    }
}
