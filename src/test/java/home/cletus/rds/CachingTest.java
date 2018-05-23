package home.cletus.rds;

import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import home.cletus.rds.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void caching() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder().id(1).name("Cletus").build());
        customers.add(Customer.builder().id(2).name("RegularCustomer").build());
        given(customerRepository.findAll()).willReturn(customers);

        customerService.findAllCustomer();
        customerService.findAllCustomer();

        verify(customerRepository, times(1)).findAll();
    }
}
