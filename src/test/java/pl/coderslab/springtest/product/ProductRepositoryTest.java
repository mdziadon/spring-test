package pl.coderslab.springtest.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.springtest.student.Student;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldFindFirstByName() {
        // given
        Product product = new Product();
        product.setName("Product1");
        entityManager.persist(product);

        // when
        Product result = productRepository.findFirstByName("Product1");

        // then
        assertNotNull(result);
        assertThat(result.getName(), is(product.getName()));
    }

    @Test
    public void shouldFindByAvailableTrue() {
        // given
        Product product1 = new Product();
        product1.setName("Product1");
        product1.setAvailable(true);
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setName("Product2");
        product2.setAvailable(false);
        entityManager.persist(product2);

        // when
        List<Product> result = productRepository.findByAvailableTrue();

        // then
        assertThat(result, hasItem(product1));

    }
}