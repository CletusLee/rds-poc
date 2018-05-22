package home.cletus.rds;

import home.cletus.rds.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= RANDOM_PORT)
public class RdsPocApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getVipCustomer() {
		ResponseEntity<Customer> reponse = testRestTemplate.getForEntity("/customer/1", Customer.class);

		assertThat(reponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(reponse.getBody().getName()).isEqualTo("Cletus");
		assertThat(reponse.getBody().getAge()).isEqualTo(18);
	}

}
