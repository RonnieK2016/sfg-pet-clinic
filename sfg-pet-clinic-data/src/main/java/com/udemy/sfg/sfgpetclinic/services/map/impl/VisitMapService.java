package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Visit;
import com.udemy.sfg.sfgpetclinic.services.VisitService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if(visit != null) {
            if(visit.getPet() == null || visit.getPet().getId() == null
                    || visit.getPet().getOwner() == null
                    || visit.getPet().getOwner().getId() == null){
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
