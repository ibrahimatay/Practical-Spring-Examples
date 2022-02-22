package dao;

import model.Department;

public interface DepartmentDAO {
    public Department findById(long id);
    public void save(Department department);
}
