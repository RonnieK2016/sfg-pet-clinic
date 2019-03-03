package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long>
        implements VetService {

    @Override
    public void delete(Vet vet) {
        super.findById(vet.getId());
    }
}
