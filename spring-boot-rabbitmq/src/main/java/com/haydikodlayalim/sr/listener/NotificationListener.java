package com.haydikodlayalim.sr.listener;

import com.haydikodlayalim.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "haydi-kodlayalim-queue")
    public void handleMessage(Notification notification) {
        System.out.println("Mesaj alındı");
        System.out.println(notification.toString());
    }
}
