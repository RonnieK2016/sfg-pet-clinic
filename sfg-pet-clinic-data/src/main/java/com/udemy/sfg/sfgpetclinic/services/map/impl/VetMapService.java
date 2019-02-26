package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;

public class VetMapService extends AbstractMapService<Vet, Long>
        implements VetService {
    @Override
    public Vet save(Vet vet) {
        super.save(vet.getId(), vet);
        return vet;
    }

    @Override
    public void delete(Vet vet) {
        super.findById(vet.getId());
    }
}
