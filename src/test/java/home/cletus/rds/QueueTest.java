package home.cletus.rds;

import home.cletus.rds.service.SqsQueueSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class QueueTest {

    @Autowired
    SqsQueueSender sqsQueueSender;

    @Test
    public void sendMessage() {
        sqsQueueSender.send("test message");
    }
}
