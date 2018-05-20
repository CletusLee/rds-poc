package home.cletus.rds.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Value("${my.profile}")
    private String myProperty;

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World[" + myProperty + "]";
    }
}
