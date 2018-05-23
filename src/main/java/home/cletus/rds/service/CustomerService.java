package home.cletus.rds.service;

import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Cacheable("customers")
    public List<Customer> findAllCustomer() {
        List<Customer> allCustomers = customerRepository.findAll();
        return allCustomers.stream().filter(customer -> customer.getId() != 1).collect(Collectors.toList());
    }
}
