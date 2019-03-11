package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Visit;
import com.udemy.sfg.sfgpetclinic.services.VisitService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if(visit != null) {
            if(visit.getPet() == null || visit.getPet().isNew()
                    || visit.getPet().getOwner() == null || visit.getPet().getOwner().isNew()){
                throw new RuntimeException("Cannot store visit: owner and pet objects should be stored first");
            }


            return super.save(visit);
        }

        return null;
    }

    @Override
    public void delete(Visit visit) {
        super.deleteById(visit.getId());
    }
}
