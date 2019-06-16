package com.booking.service;

import com.booking.model.Booking;
import com.booking.model.TripDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 14/6/19.
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private BookingService bookingService;

    @Override
    public void startTrip(final Long bookingId, final Long initialReading) {
        final Booking booking = bookingService.findBookingById(bookingId);
        final TripDetails tripDetails = new TripDetails();
        tripDetails.setBooking(booking);
        tripDetails.setInitialReading(initialReading);
        bookingService.updateBooking(booking);
    }

    @Override
    public double endTrip(final Long bookingId, final Long finalReading) throws Exception {
        final Booking booking = bookingService.findBookingById(bookingId);
        booking.getTripDetails().setEndTripReading(finalReading);
        double calculatedFare = calculateFare(booking);
        return calculatedFare;
    }

    private double calculateFare(final Booking booking) throws Exception {
        final long totalRunningKms = booking.getTripDetails().getEndTripReading() - booking.getTripDetails().getInitialReading();
        if (totalRunningKms > 0){
            return booking.getCab().getCabType().getBasicFare() * totalRunningKms;
        }else {
            throw new Exception("Invalid reading found");
        }
    }
}
