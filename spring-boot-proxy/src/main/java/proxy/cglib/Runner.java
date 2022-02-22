package proxy.cglib;

import dao.DepartmentDAOImpl;
import model.Department;
import org.springframework.cglib.proxy.Enhancer;

public class Runner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DepartmentDaoMethodInterceptor());
        enhancer.setSuperclass(DepartmentDAOImpl.class);

        DepartmentDAOImpl departmentDAO = (DepartmentDAOImpl)enhancer.create();
        Department department = departmentDAO.findById(1l);
        departmentDAO.save(department);
    }
}
