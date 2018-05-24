package home.cletus.rds.controller;

import home.cletus.rds.entity.Customer;
import home.cletus.rds.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
@Api(value = "Customer Services", description = "Services for querying and creating customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ApiOperation("Add a new customer")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful"),
                    @ApiResponse(code = 500, message = "internal sever error!!")
            }
    )
    @PutMapping("{id}")
    public ResponseEntity addCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        customer = customerRepository.save(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @ApiOperation("get a customer data")
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        Customer c = customerRepository.findById(id).get();
        return new ResponseEntity(c, HttpStatus.OK);
    }

    @ApiOperation("Generate an error")
    @GetMapping("/error")
    public ResponseEntity getError() {
        return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
    }
}
