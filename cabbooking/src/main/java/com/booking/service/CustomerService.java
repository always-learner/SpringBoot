package com.booking.service;

import com.booking.model.Customer;

/**
 * Created by sam on 13/6/19.
 */
public interface CustomerService {

    void addNewCustomer(final Customer customer);

    void updateCustomer(final Customer customer);

    void removeCustomer(final long id);

    Customer findById(final long id);
}
