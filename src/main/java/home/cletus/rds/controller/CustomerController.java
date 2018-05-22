package home.cletus.rds.controller;

import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("{id}")
    public ResponseEntity addCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        customer = customerRepository.save(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        Customer c = customerRepository.findById(id).get();
        return new ResponseEntity(c, HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity getError() {
        return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
    }
}
