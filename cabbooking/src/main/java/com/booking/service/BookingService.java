package com.booking.service;

import com.booking.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sam on 14/6/19.
 */
public interface BookingService {

    void bookCab(final Booking booking);

    List<Booking> findBookingByUser(final Long userId);

    List<Booking> findBookingByCabId(final Long cabId);

    void cancelBooking(final Long bookingId);

    void updateBooking(final Booking booking);

    Booking findBookingById(final Long bookingId);
}
