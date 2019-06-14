package com.booking.model;

/**
 * Created by sam on 12/6/19.
 */
public enum CabType {

    SEDAN(5),

    HATCHBACK(7),

    SUV(10);

    private final int basicFare;

    CabType(final int basicFare) {
        this.basicFare = basicFare;
    }

    public int getBasicFare() {
        return basicFare;
    }
}
