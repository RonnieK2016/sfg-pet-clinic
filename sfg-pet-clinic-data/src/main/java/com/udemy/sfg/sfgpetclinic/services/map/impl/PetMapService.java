package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.model.Pet;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.PetService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;

public class PetMapService extends AbstractMapService<Pet, Long>
        implements PetService {

    @Override
    public Pet save(Pet pet) {
        super.save(pet.getId(), pet);
        return pet;
    }

    @Override
    public void delete(Pet pet) {
        super.deleteById(pet.getId());
    }
}
