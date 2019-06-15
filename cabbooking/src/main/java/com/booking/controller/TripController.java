package com.booking.controller;

import com.booking.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 14/6/19.
 */
@RestController("/")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("startTrip")
    public void startTrip(@RequestParam final Long bookingId, @RequestParam final Long initialReading){
        tripService.startTrip(bookingId, initialReading);
    }

    @GetMapping("endTrip")
    public double endTrip(@RequestParam final Long bookingId, @RequestParam final Long finalReading) throws Exception {
        return tripService.endTrip(bookingId, finalReading);
    }

}
