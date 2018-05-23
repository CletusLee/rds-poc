package home.cletus.rds.repository;

import home.cletus.rds.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveData() {
        Customer c = new Customer();
        c.setName("Cletus");
        c.setAge(25);

        Customer saveEntity = entityManager.persistFlushFind(c);
        Customer result = customerRepository.findById(saveEntity.getId()).get();

        assertNotNull(result.getId());
    }
}