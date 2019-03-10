package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.SpecialityService;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long>
        implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {
        if(vet != null) {
            if(!vet.getSpecialities().isEmpty()) {
                vet.getSpecialities().forEach(specialityService::save);
            }
            return super.save(vet);
        }
        return null;
    }

    @Override
    public void delete(Vet vet) {
        super.findById(vet.getId());
    }
}
