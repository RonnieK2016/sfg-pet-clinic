package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.PetService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long>
        implements OwnerService{

    private final PetService petService;

    public OwnerMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().stream().filter(
                owner -> lastName.equals(owner.getLastName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            if(owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().forEach(petService::save);
            }
            return super.save(owner);
        }
        return null;
    }

    @Override
    public void delete(Owner owner) {
        if(owner != null) {
            if(owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().forEach(petService::delete);
            }

            super.deleteById(owner.getId());
        }
    }
}
