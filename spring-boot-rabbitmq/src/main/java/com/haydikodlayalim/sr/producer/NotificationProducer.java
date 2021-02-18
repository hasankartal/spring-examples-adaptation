package com.haydikodlayalim.sr.producer;

import com.haydikodlayalim.sr.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {
    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Haydi Kodlayalim platformuna hoşgeldiniz");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent Id : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
