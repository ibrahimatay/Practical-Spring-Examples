package service;

import annotations.Loggable;
import annotations.PerformanceLogger;
import annotations.Transaction;
import model.Student;
import org.springframework.stereotype.Service;

@Service
@Transaction
public class StudentService {
    @Loggable
    @PerformanceLogger
    public void save(Student student) {
        System.out.println("The student is saved");
    }
}
