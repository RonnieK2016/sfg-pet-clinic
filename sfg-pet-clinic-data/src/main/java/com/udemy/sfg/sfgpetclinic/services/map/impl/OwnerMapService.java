package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;


public class OwnerMapService extends AbstractMapService<Owner, Long>
        implements OwnerService{

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        super.save(owner.getId(), owner);
        return owner;
    }

    @Override
    public void delete(Owner owner) {
        super.deleteById(owner.getId());
    }
}
