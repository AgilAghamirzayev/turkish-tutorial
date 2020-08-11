package com.example.rabbit.producer;

import com.example.rabbit.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Welcome to Notification Tutorial");
        notification.setSeen(Boolean.FALSE);

        sendToProducer(notification);
    }

    public void sendToProducer(Notification notification) {
        log.info("Notification Sent ID : " + notification.getId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
