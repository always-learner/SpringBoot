package com.booking.service;

import com.booking.model.Cab;

import java.util.Date;
import java.util.List;

/**
 * Created by sam on 13/6/19.
 */
public interface CabService {

    List<Cab> findAllCabs();

    List<Cab> findAllCabs(final Date startDate, final Date endDate);

    Cab findById(long id);

    void createCab(Cab cab);

    void updateCab(Cab cab);

    void removeCab(long cabId);
}
