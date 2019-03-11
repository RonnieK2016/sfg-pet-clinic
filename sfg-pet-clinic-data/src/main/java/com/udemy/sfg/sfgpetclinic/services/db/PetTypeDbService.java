package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.PetType;
import com.udemy.sfg.sfgpetclinic.repositories.PetTypesRepository;
import com.udemy.sfg.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class PetTypeDbService implements PetTypeService {

    private final PetTypesRepository petTypesRepository;

    public PetTypeDbService(PetTypesRepository petTypesRepository) {
        this.petTypesRepository = petTypesRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypesRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypesRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypesRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypesRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypesRepository.deleteById(id);
    }
}
