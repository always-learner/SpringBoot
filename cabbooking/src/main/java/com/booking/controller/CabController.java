package com.booking.controller;

import com.booking.model.Cab;
import com.booking.service.CabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sam on 12/6/19.
 */
@RestController
@RequestMapping("/cabs")
public class CabController {

    @Autowired
    private CabServiceImpl cabServiceImpl;

    @GetMapping
    public List<Cab> findAllCabs(){
        return cabServiceImpl.findAllCabs();
    }

    @PostMapping
    public void createCab(@RequestBody  final Cab cab){
        cabServiceImpl.createCab(cab);
    }

    @PutMapping
    public void updateCab(@RequestBody final Cab cab){
        cabServiceImpl.updateCab(cab);
    }
}
