package home.cletus.rds.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Can't find the customer")
public class CustomerNotFound extends RuntimeException {
}
