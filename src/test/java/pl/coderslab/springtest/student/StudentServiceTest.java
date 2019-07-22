package pl.coderslab.springtest.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl service;

    @Mock
    private StudentRepository repository;

    @Test
    public void shouldFindByFirstName() {
        // given
        Student student = new Student("John");
        when(repository.findFirstByFirstName("John")).thenReturn(student);

        // when
        Student result = service.findByFirstName("John");

        // then
        assertThat(result, is(student));
    }

    @Test
    public void shouldAddStudent() {
        // given
        Student student = new Student("John");
        when(repository.save(student)).thenReturn(student);

        // when
        Student result = service.addStudent(student);

        // then
        assertEquals(result.getFirstName(), student.getFirstName());
    }

    @Test
    public void shouldListAllStudents() {
        // given
        Student student1 = new Student("John");
        Student student2 = new Student("Tom");
        when(repository.findAll()).thenReturn(Arrays.asList(student1, student2));

        // when
        List<Student> result = service.listAllStudents();

        // then
        assertThat(result, hasItems(student1, student2));
    }
}