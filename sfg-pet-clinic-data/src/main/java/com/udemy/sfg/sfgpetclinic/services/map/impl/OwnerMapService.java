package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;


@Service
public class OwnerMapService extends AbstractMapService<Owner, Long>
        implements OwnerService{

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public void delete(Owner owner) {
        super.deleteById(owner.getId());
    }
}
