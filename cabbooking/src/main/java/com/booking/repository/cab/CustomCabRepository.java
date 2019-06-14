package com.booking.repository.cab;

import com.booking.model.Cab;

import java.util.Date;
import java.util.List;

/**
 * Created by sam on 13/6/19.
 */
public interface CustomCabRepository {

    List<Cab> findAllByDuration(final Date startDate, final Date endDate);
}
