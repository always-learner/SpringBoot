package com.booking.controller;

import com.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 14/6/19.
 */
@RestController("/trip")
public class TripController {

    public void startTrip(@RequestParam final Long bookingId, @RequestParam final Long initialReading){

    }
}
