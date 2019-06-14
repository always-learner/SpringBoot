package com.booking.repository.cab;

import com.booking.model.Cab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sam on 12/6/19.
 */

@Repository
public interface CabRepository extends CrudRepository<Cab, Long>, CustomCabRepository {

}
