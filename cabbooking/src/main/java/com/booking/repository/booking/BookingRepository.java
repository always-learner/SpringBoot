package com.booking.repository.booking;

import com.booking.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sam on 14/6/19.
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>, CustomBookingRepository {
}
