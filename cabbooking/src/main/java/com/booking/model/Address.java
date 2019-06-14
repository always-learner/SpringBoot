package com.booking.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by sam on 12/6/19.
 */
@Embeddable
public class Address {

    @NotNull(message = "House number can not be blank")
    private String houseNumber;

    private String societyName;

    @NotNull(message = "Street name is required")
    private String street;

    @NotNull(message = "City name is required")
    private String city;

    @NotNull(message = "State can not be blank")
    private String state;

    @NotNull(message = "Postal code can not be blank")
    @Pattern(regexp = "(^$|[0-9]{6}])")
    private String pinCode;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
