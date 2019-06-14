package com.booking.controller;

import com.booking.model.Booking;
import com.booking.model.Cab;
import com.booking.service.BookingService;
import com.booking.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by sam on 13/6/19.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private CabService cabService;

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Cab> getAvailableCabs(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") final Date startDate,
                                      @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") final Date endDate){
        return cabService.findAllCabs(startDate, endDate);
    }

    @PostMapping
    public void bookCab(@RequestBody final Booking booking){
        bookingService.bookCab(booking);
    }

    @GetMapping("/customer/{userId}")
    public List<Booking> findBookingsByUserId(@PathVariable final long userId){
        return bookingService.findBookingByUser(userId);
    }

    @GetMapping("/cab/{cabId}")
    public List<Booking> findBookingsByCabId(@PathVariable final long cabId){
        return bookingService.findBookingByCabId(cabId);
    }

    @PutMapping
    public void updateBooking(@RequestBody final Booking booking){
        bookingService.updateBooking(booking);
    }
}
