package pl.coderslab.springtest.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/list")
    public String list(Model model) {
        List<Student> students = studentService.listAllStudents();
        model.addAttribute("students", students);
        return "student/studentList";
    }
}
