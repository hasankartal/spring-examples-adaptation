package com.haydikodlayalim.events.event.listener;

import com.haydikodlayalim.events.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventListener(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("Event Listener -> " + reservationCreatedEvent.getSource().toString());
    }
}
