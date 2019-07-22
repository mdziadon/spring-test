package pl.coderslab.springtest.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> listAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findByFirstName(String firstName) {
        return repository.findFirstByFirstName(firstName);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }
}
