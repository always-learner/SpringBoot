package com.booking.repository;

import com.booking.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sam on 12/6/19.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
