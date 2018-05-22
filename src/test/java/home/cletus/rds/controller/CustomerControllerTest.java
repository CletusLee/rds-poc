package home.cletus.rds.controller;

import home.cletus.rds.controller.exception.CustomerNotFound;
import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void getVipCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setName("Cletus");
        customer.setAge(18);
        Optional<Customer> customerOptional = Optional.of(customer);
        given(customerRepository.findById(1)).willReturn(customerOptional);

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Cletus"))
                .andExpect(jsonPath("age").value(18));

    }

    @Test
    public void customerNotFound() throws Exception {
        given(customerRepository.findById(anyInt())).willThrow(new CustomerNotFound());
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/2"))
                .andExpect(status().isNotFound());
    }
}