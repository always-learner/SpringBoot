package com.booking.service;

import com.booking.model.Cab;
import com.booking.repository.cab.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sam on 12/6/19.
 */
@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepository cabRepository;

    @Override
    public List<Cab> findAllCabs(){
        final List<Cab> cabs = new ArrayList<>();
        cabRepository.findAll().iterator().forEachRemaining(cabs::add);
        return cabs;
    }

    @Override
    public Cab findById(final long id){
        return cabRepository.findById(id).get();
    }

    @Override
    public void createCab(final Cab cab){
        cabRepository.save(cab);
    }

    @Override
    public void updateCab(final Cab cab){
        cabRepository.save(cab);
    }

    @Override
    public void removeCab(final long cabId){
        cabRepository.deleteById(cabId);
    }

    @Override
    public List<Cab> findAllCabs(final Date startDate, final Date endDate) {
        return cabRepository.findAllByDuration(startDate, endDate);
    }
}
