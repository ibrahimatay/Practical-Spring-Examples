package dao;

import lombok.SneakyThrows;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.*;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveEmployee(Employee employee) {
        if(employee.getId() < 0) {
            throw new IllegalArgumentException("Employee Id has to be greater than zero");
        }

        int numberOfRecordsInserted = jdbcTemplate.update(
                "insert into employee(employee_id, first_name, last_name, email, phone_number, hire_date, salary) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary()
        );

        if(numberOfRecordsInserted == 1) {
            System.out.println(String.format("Saved employee [%d]", employee.getId()));
        } else {
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordsInserted));
        }
    }

    public List<Employee> findAllEmployeesByIdRange(int minId, int maxId) {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary " +
                        "from employee " +
                        "where employee_id between ? and ?",
                new Object[]{minId, maxId},
                this::mapEmployee
        );
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int i) {
        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")
        );
    }

    @Transactional(propagation = REQUIRED)
    public void requiredTransactionMethod() {
    }

    @Transactional(propagation = SUPPORTS)
    public void supportsTransactionMethod() {
    }

    @Transactional(propagation = MANDATORY)
    public void mandatoryTransactionMethod() {
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void requiresNewTransactionMethod() {
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public void notSupportedTransactionMethod() {
    }

    @Transactional(propagation = NEVER)
    public void neverTransactionMethod() {
    }

    @Transactional(propagation = NESTED)
    public void nestedTransactionMethod() {
    }
}
