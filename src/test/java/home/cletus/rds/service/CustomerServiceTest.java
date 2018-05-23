package home.cletus.rds.service;

import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void getAllCustomerShouldFilterVip() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder().id(1).name("Cletus").build());
        customers.add(Customer.builder().id(2).name("RegularCustomer").build());
        given(customerRepository.findAll()).willReturn(customers);

        List<Customer> foundCustomers = customerService.findAllCustomer();

        assertThat(foundCustomers.size()).isEqualTo(1);
        assertThat(foundCustomers.get(0).getId()).isEqualTo(2);
    }
}