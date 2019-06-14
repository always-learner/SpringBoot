package com.booking.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by sam on 12/6/19.
 */
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Name can not be blank")
    private String name;

    @NotNull(message = "Email can not be blank")
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Mobile number can not be blank")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Invalid mobile number")
    private String mobileNumber;

    @NotNull(message = "Driving license is mandatory to drive a car")
    private String drivingLicense;

    @NotNull(message = "Password can not be blank")
    private String password;

    @Embedded
    @NotNull(message = "Address can not be blank")
    private Address address;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        return mobileNumber != null ? mobileNumber.equals(customer.mobileNumber) : customer.mobileNumber == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        return result;
    }
}
