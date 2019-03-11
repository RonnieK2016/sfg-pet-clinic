package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Speciality;
import com.udemy.sfg.sfgpetclinic.repositories.SpecialitiesRepository;
import com.udemy.sfg.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class SpecialityDbService implements SpecialityService {

    private final SpecialitiesRepository specialitiesRepository;

    public SpecialityDbService(SpecialitiesRepository specialitiesRepository) {
        this.specialitiesRepository = specialitiesRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialitiesRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialitiesRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialitiesRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialitiesRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialitiesRepository.deleteById(id);
    }
}
