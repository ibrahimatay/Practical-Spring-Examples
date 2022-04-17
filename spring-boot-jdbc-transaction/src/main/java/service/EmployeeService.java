package service;

import dao.EmployeeDao;
import exception.CustomException;
import model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
//@Transactional(isolation = Isolation.SERIALIZABLE)
//@Transactional(isolation = Isolation.REPEATABLE_READ)
//@Transactional(isolation = Isolation.READ_COMMITTED)
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployeeWithoutTransaction() {
        System.out.println("Saving employee without transaction...");
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }

    @Transactional
    public void saveEmployeeWithTransaction() {
        System.out.println("Saving employee with transaction...");
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }

    public void callRequiredWithoutCurrentTransaction() {
        employeeDao.requiredTransactionMethod();
    }

    @Transactional
    public void callRequiredWithCurrentTransaction() {
        employeeDao.requiredTransactionMethod();
    }

    public void callSupportsWithoutCurrentTransaction() {
        employeeDao.supportsTransactionMethod();
    }

    @Transactional
    public void callSupportsWithCurrentTransaction() {
        employeeDao.supportsTransactionMethod();
    }

    public void callMandatoryWithoutCurrentTransaction() {
        employeeDao.mandatoryTransactionMethod();
    }

    @Transactional
    public void callMandatoryWithCurrentTransaction() {
        employeeDao.mandatoryTransactionMethod();
    }

    public void callRequiresNewWithoutCurrentTransaction() {
        employeeDao.requiresNewTransactionMethod();
    }

    @Transactional
    public void callRequiresNewWithCurrentTransaction() {
        employeeDao.requiresNewTransactionMethod();
    }

    public void callNotSupportedWithoutCurrentTransaction() {
        employeeDao.notSupportedTransactionMethod();
    }

    @Transactional
    public void callNotSupportedWithCurrentTransaction() {
        employeeDao.notSupportedTransactionMethod();
    }

    public void callNeverWithoutCurrentTransaction() {
        employeeDao.neverTransactionMethod();
    }

    @Transactional
    public void callNeverWithCurrentTransaction() {
        employeeDao.neverTransactionMethod();
    }

    public void callNestedWithoutCurrentTransaction() {
        employeeDao.nestedTransactionMethod();
    }

    @Transactional
    public void callNestedWithCurrentTransaction() {
        employeeDao.nestedTransactionMethod();
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public void methodWithUncheckedExceptionNotCausingRollback() {
        throw new IllegalArgumentException("test unchecked exception that will not cause rollback because of noRollbackFor field");
    }

    @Transactional(rollbackFor = CustomException.class)
    public void methodWithCheckedExceptionCausingRollback() throws CustomException {
        throw new CustomException("test checked exception that will cause rollback because of rollbackFor field");
    }
}
