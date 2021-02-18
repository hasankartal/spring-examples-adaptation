package com.haydikodlayalim.events.api;

import com.haydikodlayalim.events.request.HotelBookRequest;
import com.haydikodlayalim.events.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingApi {

    @Autowired
    private ReservationService reservationService;

    @PostMapping // http://localhost:8046/book
    public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest) {
        reservationService.publishReservationEvent(hotelBookRequest);
        System.out.println("Kullanıcı isteği işleme alındı." + hotelBookRequest);
    }
}
