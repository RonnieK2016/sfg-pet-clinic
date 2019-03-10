package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Speciality;
import com.udemy.sfg.sfgpetclinic.services.SpecialityService;
import com.udemy.sfg.sfgpetclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long>
        implements SpecialityService {

    @Override
    public void delete(Speciality speciality) {
        if(speciality != null) {
            super.deleteById(speciality.getId());
        }
    }
}
