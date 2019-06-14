package com.booking.controller;

import com.booking.model.Cab;
import com.booking.service.CabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sam on 12/6/19.
 */
@RestController
public class CabController {

    @Autowired
    private CabServiceImpl cabServiceImpl;

    @GetMapping("/cabs")
    public List<Cab> findAllCabs(){
        return cabServiceImpl.findAllCabs();
    }

    @PostMapping("/cabs")
    public void createCab(@RequestBody  final Cab cab){
        cabServiceImpl.createCab(cab);
    }
}
