package pl.coderslab.springtest.student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudents();

    Student findByFirstName(String firstName);

    Student addStudent(Student student);

}
