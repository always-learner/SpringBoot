package com.booking.controller;

import com.booking.model.Customer;
import com.booking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sam on 13/6/19.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody final Customer customer){
        customerService.addNewCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody final Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void removeCustomer(@PathVariable final long id){
        customerService.removeCustomer(id);
    }

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable final long id){
        return customerService.findById(id);
    }

}
