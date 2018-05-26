package home.cletus.rds.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqsQueueSender {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value(value = "${my.cloud.queue.name}")
    private String queueName;

    @Autowired
    public SqsQueueSender(AmazonSQSAsync amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSqs);
    }

    public void send(String message) {
        this.queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(message).build());
    }
}