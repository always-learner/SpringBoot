package com.booking.repository.booking;

import com.booking.model.Booking;

import java.util.List;

/**
 * Created by sam on 14/6/19.
 */
public interface CustomBookingRepository {

    List<Booking> findBookingByUser(final Long userId);

    List<Booking> findBookingByCabId(final Long cabId);

    void cancelBooking(final Long bookingId);
}
