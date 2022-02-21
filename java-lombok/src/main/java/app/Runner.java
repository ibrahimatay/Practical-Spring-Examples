package app;

import model.Person;
import model.School;
import model.Student;

public class Runner {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1L);
        person.setName("Jon");
        person.setSurname("Doe");

        System.out.println(person);

        var school = School.builder()
                                    .name("Sakarya University")
                                    .id(2L)
                                    .build();
        System.out.println(school);

        Student student = new Student();
        student.setId(3L);
        student.setName("Markus");
        student.setSurname("Lean");

        System.out.println(student);
    }
}
