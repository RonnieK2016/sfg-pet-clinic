package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.PetType;
import com.udemy.sfg.sfgpetclinic.services.PetTypeService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long>
        implements PetTypeService {

    @Override
    public void delete(PetType petType) {
        super.deleteById(petType.getId());
    }
}
