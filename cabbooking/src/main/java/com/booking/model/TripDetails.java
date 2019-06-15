package com.booking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sam on 12/6/19.
 */
@Entity(name = "trip_details")
public class TripDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long initialReading;

    @OneToOne(mappedBy = "tripDetails")
    private Booking booking;

    private long endTripReading;

    public long getInitialReading() {
        return initialReading;
    }

    public void setInitialReading(long initialReading) {
        this.initialReading = initialReading;
    }

    public long getEndTripReading() {
        return endTripReading;
    }

    public void setEndTripReading(long endTripReading) {
        this.endTripReading = endTripReading;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripDetails that = (TripDetails) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
