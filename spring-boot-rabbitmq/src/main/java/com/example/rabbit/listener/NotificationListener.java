package com.example.rabbit.listener;

import com.example.rabbit.model.Notification;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class NotificationListener {

    @RabbitListener(queues = "example-queue")
    public void handleMessage(Notification notification) {
        log.info("Message received...");
        log.info(notification.toString());
    }
}
