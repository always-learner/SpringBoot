package com.booking.service;

import com.booking.model.Cab;
import com.booking.model.CabType;
import com.booking.repository.cab.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sam on 12/6/19.
 */
@Service
@CacheConfig(cacheNames = "cabs")
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepository cabRepository;

    @Override
    @Cacheable
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
        for (int i=0;i<1000;i++){
            final Cab cab1 = new Cab();
                    cab1.setCabType(CabType.SEDAN);
                    cab1.setName("Test name 2");
                    cab1.setCabNumber("MH14DC7751");
                    cabRepository.save(cab1);
        }
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
