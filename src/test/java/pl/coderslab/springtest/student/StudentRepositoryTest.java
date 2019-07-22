package pl.coderslab.springtest.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldFindFirstByFirstName() {
        // given
        Student student = new Student();
        student.setFirstName("John");
        entityManager.persist(student);

        // when
        Student result = studentRepository.findFirstByFirstName("John");

        // then
        assertNotNull(result);
        assertThat(result.getFirstName(), is(student.getFirstName()));
    }

    @Test
    public void shouldFindByFirstNameStartingWith() {
        // given
        Student jo = new Student();
        jo.setFirstName("Jo");
        entityManager.persist(jo);

        Student john = new Student();
        john.setFirstName("John");
        entityManager.persist(john);

        // when
        List<Student> result = studentRepository.findByFirstNameStartingWith("Jo");

        // then
        assertThat(result, hasItems(jo, john));
    }
}