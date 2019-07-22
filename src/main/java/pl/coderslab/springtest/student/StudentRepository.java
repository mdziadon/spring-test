package pl.coderslab.springtest.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findFirstByFirstName(String firstName);

    List<Student> findByFirstNameStartingWith(String firstNamePrefix);
}
