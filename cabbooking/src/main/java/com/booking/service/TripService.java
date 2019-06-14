package com.booking.service;

/**
 * Created by sam on 14/6/19.
 */
public interface TripService {

    void startTrip(final Long bookingId, final Long initialReading);

    double endTrip(final Long bookingId, final Long finalReading) throws Exception;
}
