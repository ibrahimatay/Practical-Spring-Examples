package dao;


import lombok.SneakyThrows;
import model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee
        );
    }

    public Employee findFirstHiredEmployee() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by hire_date limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeWithHighestSalary() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by salary desc limit 1",
                this::mapEmployee
        );
    }

    public Float findAverageSalaryCalculatedOnEntireResultSet() {
        return jdbcTemplate.query(
                "select salary from employee",
                new AverageSalaryResultSetExtractor()
        );
    }

    private static class AverageSalaryResultSetExtractor implements ResultSetExtractor<Float> {
        @Override
        public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
            float salarySum = 0;
            int salariesCount = 0;

            while (rs.next()) {
                salarySum += rs.getFloat("salary");
                ++salariesCount;
            }

            return salarySum / (float) salariesCount;
        }
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
}
