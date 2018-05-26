package home.cletus.rds.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SqsQueueReceiver {

    @SqsListener("${my.cloud.queue.name}")
    public void queueListener(String message) {
        System.out.println("--------------- Got Message -------------");
        System.out.print("Message = " + message);
    }
}
