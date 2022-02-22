package dao;

import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO{
    public Department findById(long id) {
        System.out.println("Searching for department...");
        return new Department();
    }

    public void save(Department department) {
        System.out.println("Saving department...");
    }
}
