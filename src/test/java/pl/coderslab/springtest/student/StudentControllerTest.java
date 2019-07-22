package pl.coderslab.springtest.student;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {

    private final String STUDENT_LIST_ACTION_VIEW = "student/studentList";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private StudentService studentService;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        List<Student> students = Arrays.asList(new Student("Jan"),
                new Student("Janek"), new Student("Janusz"));
        when(this.studentService.listAllStudents()).thenReturn(students);
    }

    @Test
    public void shouldReturnList() throws Exception {
        mockMvc.perform(get("/students/list"))
                .andExpect(model().attributeExists("students"))
                .andExpect(status().isOk())
                .andExpect(view().name(STUDENT_LIST_ACTION_VIEW));
    }
}