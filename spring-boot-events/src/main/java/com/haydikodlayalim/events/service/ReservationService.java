package com.haydikodlayalim.events.service;

import com.haydikodlayalim.events.api.BookingApi;
import com.haydikodlayalim.events.event.ReservationCreatedEvent;
import com.haydikodlayalim.events.request.HotelBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(HotelBookRequest hotelBookRequest) {
        try {
            Thread.sleep(0000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
