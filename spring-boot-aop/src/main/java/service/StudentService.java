package service;

import annotations.Loggable;
import model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Loggable
    public void save(Student student) {
        System.out.println("The student is saved");
    }
}
