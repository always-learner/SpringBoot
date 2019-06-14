package com.booking.service;

import com.booking.model.Customer;
import com.booking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 13/6/19.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addNewCustomer(final Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(final Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(final long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }
}
