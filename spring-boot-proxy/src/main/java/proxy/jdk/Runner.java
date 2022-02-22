package proxy.jdk;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import model.Department;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = (DepartmentDAO) Proxy.newProxyInstance(
            DepartmentDAO.class.getClassLoader(), DepartmentDAOImpl.class.getInterfaces(),
                new DepartmentDAOInvocationHandler(
                        new DepartmentDAOImpl()
                )
        );

        departmentDAO.findById(1l);
        departmentDAO.save(new Department());
    }
}
