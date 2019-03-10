package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Pet;
import com.udemy.sfg.sfgpetclinic.services.PetService;
import com.udemy.sfg.sfgpetclinic.services.PetTypeService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long>
        implements PetService {

    private final PetTypeService petTypeService;

    public PetMapService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(Pet pet) {
        if(pet != null) {
            if(pet.getPetType() != null) {
                petTypeService.save(pet.getPetType());
            }
            else {
                throw new RuntimeException("Can't save pet " + pet + ": petType is null");
            }
            return super.save(pet);
        }
        return null;
    }

    @Override
    public void delete(Pet pet) {
        if(pet != null) {
            petTypeService.delete(pet.getPetType());
            super.deleteById(pet.getId());
        }
    }
}
