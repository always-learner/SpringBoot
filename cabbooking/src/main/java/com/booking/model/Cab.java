package com.booking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sam on 12/6/19.
 */
@Entity(name = "cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Cab type can not be null")
    @Enumerated(EnumType.STRING)
    private CabType cabType;

    @NotNull(message = "Cab name can not be null")
    private String name;

    @NotNull(message = "Cab name is mandatory")
    private String cabNumber;

    public long getId() {
        return id;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cab cab = (Cab) o;

        return cabNumber != null ? cabNumber.equals(cab.cabNumber) : cab.cabNumber == null;
    }

    @Override
    public int hashCode() {
        return cabNumber != null ? cabNumber.hashCode() : 0;
    }
}
