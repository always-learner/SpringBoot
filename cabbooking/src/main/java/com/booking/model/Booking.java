package com.booking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sam on 12/6/19.
 */
@Entity(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @NotNull(message = "Cab is not selected for booking")
    @JoinColumn(name = "cab_id")
    private Cab cab;

    @OneToOne
    @NotNull(message = "Booking can not proceed without user details")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBooking;

    @NotNull(message = "Trip start date can not be blank")
    private Date tripStartDate;

    @NotNull(message = "Trip end date can not be blank")
    private Date tripEndDate;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private TripDetails tripDetails;

    public long getId() {
        return id;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Date getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(Date tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public Date getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(Date tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public TripDetails getTripDetails() {
        return tripDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (cab != null ? !cab.equals(booking.cab) : booking.cab != null) return false;
        if (customer != null ? !customer.equals(booking.customer) : booking.customer != null) return false;
        if (dateOfBooking != null ? !dateOfBooking.equals(booking.dateOfBooking) : booking.dateOfBooking != null)
            return false;
        if (tripStartDate != null ? !tripStartDate.equals(booking.tripStartDate) : booking.tripStartDate != null)
            return false;
        return tripEndDate != null ? tripEndDate.equals(booking.tripEndDate) : booking.tripEndDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cab != null ? cab.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (dateOfBooking != null ? dateOfBooking.hashCode() : 0);
        result = 31 * result + (tripStartDate != null ? tripStartDate.hashCode() : 0);
        result = 31 * result + (tripEndDate != null ? tripEndDate.hashCode() : 0);
        return result;
    }
}
