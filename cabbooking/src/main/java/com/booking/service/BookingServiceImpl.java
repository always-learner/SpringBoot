package com.booking.service;

import com.booking.model.Booking;
import com.booking.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sam on 14/6/19.
 */

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void bookCab(final Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findBookingByUser(final Long userId) {
        return bookingRepository.findBookingByUser(userId);
    }

    @Override
    public List<Booking> findBookingByCabId(final Long cabId) {
        return bookingRepository.findBookingByCabId(cabId);
    }

    @Override
    public void cancelBooking(Long bookingId) {

    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking findBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).get();
    }
}
