package home.cletus.rds;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
public class RdsPocApplication {

	@Value("${my.profile}")
	private String myProperty;

	public static void main(String[] args) {
		SpringApplication.run(RdsPocApplication.class, args);
	}

	@RequestMapping("/profile")
	public String helloWorld() {
		return "Hello World[" + myProperty + "]!!";
	}
}
